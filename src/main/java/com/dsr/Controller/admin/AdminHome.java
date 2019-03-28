package com.dsr.Controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {


    @RequestMapping
    public String adminPage()
    {
        return "addUser";
    }

}
