package com.xen.spring.db_client.controller;


import com.xen.spring.db_client.service.ProductionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CountController {

    @Autowired
    ProductionPlanService service;

    @RequestMapping("/countPlan")
    public String countPlan(Model model, HttpServletRequest request) {
        String section = request.getParameter("section");
        if (section != null && !section.equals("")) {
            double result = service.countSum(section);
            if (result == -1) {
                model.addAttribute("section", "Такого участка нет");
            }
            else {
                model.addAttribute("section", "Вы смотрите участок: " + section);
                model.addAttribute("sum", result);
            }
        }
        return "count-profit";
    }

}
