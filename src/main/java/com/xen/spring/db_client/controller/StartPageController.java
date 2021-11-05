package com.xen.spring.db_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPageController {

    @RequestMapping("/")
    public String startPage() {
        return "start-page";
    }
}
