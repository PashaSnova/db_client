package com.xen.spring.db_client.controller;

import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.ProductionPlanId;
import com.xen.spring.db_client.entity.WorkshopDirectoryId;
import com.xen.spring.db_client.service.ProductionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String savePlan(@Valid @ModelAttribute ProductionPlan plan, BindingResult result) {
        if (result.hasErrors())
            return "plan-info";
        service.addPlan(plan);
        return "redirect:/productionPlan";
    }

    @RequestMapping("/deletePlan")
    public String deletePlan(@RequestParam("det_id") int detId,
                             @RequestParam("wNumber") int wNumber,
                             @RequestParam("sNumber") int sNumber,
                             @RequestParam("year") int releaseYear,
                             @RequestParam("month") String releaseMonth) {
        service.deletePlan(new ProductionPlanId(detId, new WorkshopDirectoryId(wNumber, sNumber), releaseYear, releaseMonth));
        return "redirect:/productionPlan";
    }


    @RequestMapping("/updatePlan")
    public String updatePlan(@RequestParam("det_id") int detId,
                             @RequestParam("wNumber") int wNumber,
                             @RequestParam("sNumber") int sNumber,
                             @RequestParam("year") int releaseYear,
                             @RequestParam("month") String releaseMonth,
                             Model model) {
        ProductionPlan plan = service.getPlanById(new ProductionPlanId(detId, new WorkshopDirectoryId(wNumber, sNumber), releaseYear, releaseMonth));
        model.addAttribute("plan", plan);
        return "plan-info";
    }



    @ExceptionHandler
    public String handleException(Exception exception) {
        return "error-info-plan";
    }

}
