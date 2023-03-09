package com.example.demoMVCproject.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.*;
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandling()
    {
       return "exception" ;
    }

}
