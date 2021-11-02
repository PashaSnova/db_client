package com.xen.spring.db_client.controller;

import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.service.ProductionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductionPlanController {

    @Autowired
    ProductionPlanService service;

    @RequestMapping("/productionPlan")
    public String getPlan(Model model) {
        model.addAttribute("plan", service.getPlan());
        return "all-plan";
    }

    @RequestMapping("addPlan")
    public String addPlan(Model model) {
        model.addAttribute("plan", new ProductionPlan());
        return "plan-info";
    }

    @RequestMapping("savePlan")
    public String savePlan(@ModelAttribute ProductionPlan plan) {
        service.addPlan(plan);
        return "redirect:/productionPlan";
    }

    @ExceptionHandler
    public String handleException(Exception exception) {
        return "error-info-plan";
    }

}
