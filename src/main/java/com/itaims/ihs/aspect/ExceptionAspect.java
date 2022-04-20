package com.itaims.ihs.aspect;

import com.itaims.ihs.entity.AuditableBase;
import com.itaims.ihs.error.IdNotPresentException;
import com.itaims.ihs.error.ObjectNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExceptionAspect {
    Logger logger = Logger.getLogger(ExceptionAspect.class.getName());

    /**
     * @param joinPoint
     * @brief Check for null before deleting the object.
     */
    @Before("execution(* com.itaims.ihs.dao.*.delete(*))")
    public void checkForObjectNull(JoinPoint joinPoint) {
        Object object = joinPoint.getArgs()[0];
        if (object == null) {
            logger.warning("Object is not found with given id");
            throw new ObjectNotFoundException("Object is not found with given id");
        }
    }


    /**
     * @param joinPoint
     * @breif Check for id before updating the object.
     */
    @Before("execution(* com.itaims.ihs.controller.rest.*.update(..))")
    public void checkThePresenceOfIdWhileUpdate(JoinPoint joinPoint) {
        AuditableBase object = (AuditableBase) joinPoint.getArgs()[0];
        logger.warning("inside the Before for id presence " + object);
        if (object.getId() == 0) {
            logger.warning("Id must be present during PUT request");
            throw new IdNotPresentException("Id must be present during PUT request", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param result
     * @brief Check if result of "get(..)" method in dao is null or not
     */
    @AfterReturning(pointcut = "execution(* com.itaims.ihs.dao.*.get(..))", returning = "result")
    public void getObjectNotNull(Object result) {
        if (result == null) {
            logger.warning("Object is not found with given id");
            throw new ObjectNotFoundException("Object is not found with given id");
        }
    }
}
