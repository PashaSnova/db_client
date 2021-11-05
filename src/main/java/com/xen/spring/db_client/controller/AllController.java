package com.xen.spring.db_client.controller;

import com.xen.spring.db_client.service.DetailService;
import com.xen.spring.db_client.service.ProductionPlanService;
import com.xen.spring.db_client.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {

    @Autowired
    DetailService detailService;

    @Autowired
    WorkshopService workshopService;

    @Autowired
    ProductionPlanService planService;

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("details", detailService.getAllDetails());
        model.addAttribute("workshops", workshopService.getAllWorkshops());
        model.addAttribute("plan", planService.getPlan());
        return "all";
    }
}
