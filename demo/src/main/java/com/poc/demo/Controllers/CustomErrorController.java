package com.poc.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class CustomErrorController implements ErrorController{
    
    @GetMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        String errorTemplate = new String();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null && Integer.valueOf(status.toString()) == HttpStatus.NOT_FOUND.value()){
            errorTemplate = "404";
        }else{
            errorTemplate = "error";
        }
        return errorTemplate;
    }
    
}
