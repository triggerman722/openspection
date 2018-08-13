package com.openspection.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GlobalExceptionController {
    @RequestMapping(value = "/globalerror", method = RequestMethod.GET)
    public String globalerror() {
        return "globalerror";
    }

}
