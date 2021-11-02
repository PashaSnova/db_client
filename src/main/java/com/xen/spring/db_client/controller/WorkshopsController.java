package com.xen.spring.db_client.controller;

import com.xen.spring.db_client.entity.WorkshopDirectory;
import com.xen.spring.db_client.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WorkshopsController {

    @Autowired
    WorkshopService service;

    @RequestMapping("/workshops")
    public String getAllWorkshops(Model model) {
        List<WorkshopDirectory> list = service.getAllWorkshops();
        model.addAttribute("workshops", list);
        return "all-workshops";
    }

    @RequestMapping("addWorkshopSection")
    public String addWorkshopSection(Model model) {
        WorkshopDirectory directory = new WorkshopDirectory();
        model.addAttribute("workshopDirectory", directory);
        return "workshop-info";
    }

    @RequestMapping("/saveWorkshopSection")
    public String saveWorkshopSection(@ModelAttribute("workshopDirectory") WorkshopDirectory workshopDirectory) {
        service.addWorkshop(workshopDirectory);
        return "redirect:/workshops";
    }

    @ExceptionHandler
    public String handleException(Exception exception) {
        return "error-info-workshops";
    }
}


