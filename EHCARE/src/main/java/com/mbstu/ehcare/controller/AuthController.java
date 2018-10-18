package com.mbstu.ehcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginView(Model model) {
       return "login";
    }

}
