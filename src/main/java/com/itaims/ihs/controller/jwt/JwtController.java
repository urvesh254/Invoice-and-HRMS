package com.itaims.ihs.controller.jwt;

import com.itaims.ihs.entity.JwtInvalidToken;
import com.itaims.ihs.error.CustomException;
import com.itaims.ihs.request.JwtRequest;
import com.itaims.ihs.response.JwtResponse;
import com.itaims.ihs.service.CustomUserDetailsService;
import com.itaims.ihs.service.JwtInvalidTokenService;
import com.itaims.ihs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.logging.Logger;

@RestController
public class JwtController {
    private static final Logger logger = Logger.getLogger(JwtController.class.getName());
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtInvalidTokenService jwtInvalidTokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        logger.info(jwtRequest.toString());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (UsernameNotFoundException | BadCredentialsException be) {
            throw new CustomException("Login failed wrong user credentials", HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            throw new CustomException("Server Error!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        logger.info(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/invalidateToken")
    public void logout(@RequestBody JwtResponse jwtResponse) throws Exception {
        logger.info(jwtResponse.toString());
        Date validTill = jwtUtil.extractExpiration(jwtResponse.getToken());

        JwtInvalidToken object = new JwtInvalidToken();
        object.setToken(jwtResponse.getToken());
        object.setValidTill(validTill);

        jwtInvalidTokenService.save(object);
    }

}