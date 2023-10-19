package com.in28minutes.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {
    private Log logger = LogFactory.getLog(ExceptionController.class);
    @ExceptionHandler(value=Exception.class)
    public String handleException(HttpServletRequest request, Exception exception){
        logger.error("Request : " + request.getRequestURL() + " threw an Exception.", exception);
        return "error";
    }
}
