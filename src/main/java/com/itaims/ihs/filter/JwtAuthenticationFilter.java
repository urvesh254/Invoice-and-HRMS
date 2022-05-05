package com.itaims.ihs.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itaims.ihs.entity.JwtInvalidToken;
import com.itaims.ihs.response.ErrorResponse;
import com.itaims.ihs.service.CustomUserDetailsService;
import com.itaims.ihs.service.JwtInvalidTokenService;
import com.itaims.ihs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger logger = Logger.getLogger(JwtAuthenticationFilter.class.getName());

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtInvalidTokenService jwtInvalidTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ErrorResponse errorResponse;
        String requestToken = request.getHeader("Authorization");

        // Testing purpose
        logger.info("=======================================");
        logger.info("Requested URL: " + request.getRequestURI());
        logger.info("Method Name: " + request.getMethod());
        logger.info("=======================================");

        // Exception for Authorization header.
        if (request.getRequestURI().startsWith("/token") || request.getRequestURI().startsWith("/invalidateToken")) {
            logger.info("/login or /logout found" + request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        // Validate token
        if (requestToken != null && requestToken.startsWith("Bearer ")) {
            String username;
            String jwtToken = requestToken.substring(7);

            // check if this token is present in the invalid_tokens or not
            JwtInvalidToken invalidToken = jwtInvalidTokenService.getByToken(jwtToken);
            logger.info(invalidToken == null ? null : invalidToken.toString());
            if (invalidToken != null) {
                errorResponse = new ErrorResponse("Invalid Token", HttpStatus.UNAUTHORIZED.value());
                handleFilterException(response, errorResponse);
                return;
            }

            try {
                username = this.jwtUtil.extractUsername(jwtToken);
            } catch (Exception e) {
                logger.warning(e.getMessage());
                errorResponse = new ErrorResponse("Invalid Token", HttpStatus.UNAUTHORIZED.value());
                handleFilterException(response, errorResponse);
                return;
            }

            // load user from database.
            try {
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                } else {
                    throw new Exception("Invalid Token.");
                }
            } catch (Exception e) {
                logger.info("Token is not validated.");
                errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
                handleFilterException(response, errorResponse);
                return;
            }


        } else {
            logger.info("in filter exception not login and logout");
            errorResponse = new ErrorResponse("You must add authorization header in request.", HttpStatus.BAD_REQUEST.value());
            handleFilterException(response, errorResponse);
            return;
        }
        logger.info("in filter");

        filterChain.doFilter(request, response);

    }

    private void handleFilterException(HttpServletResponse response, ErrorResponse errorResponse) throws IOException {
        String jsonException = convertObjectToJSON(errorResponse);

        response.setContentType("application/json");
        response.setStatus(errorResponse.getStatus());
        response.getWriter().write(jsonException);
        response.getWriter().close();
    }

    private String convertObjectToJSON(Object object) throws JsonProcessingException {
        if (object == null) return "";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


}
