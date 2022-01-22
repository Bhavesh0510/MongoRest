package com.example.MongoRestAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ControllerAdvice
public class AppExceptionHandler{

    @ExceptionHandler(value = NullPointerException.class)
    public String handelNullPointerException(Model model){
        model.addAttribute("errorMsg", "Some Problem Occured. Please Try Again After Sometime..!!");
        return "error";
    }

//    @ExceptionHandler
//    public <UserNotFoundException> ResponseEntity<Object> exceptionHandler(UserNotFoundException ex){
//        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
}
