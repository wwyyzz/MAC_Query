package com.wj.MAC_Query.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class macaddrController {

    @ResponseBody
    @RequestMapping("/")
    public String query(){
        return "Hello !";
    }
}
