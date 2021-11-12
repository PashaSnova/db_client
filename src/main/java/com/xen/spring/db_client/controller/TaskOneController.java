package com.xen.spring.db_client.controller;


import com.xen.spring.db_client.additional_methods.Addition;
import com.xen.spring.db_client.entity.ProductionPlan;
import com.xen.spring.db_client.entity.WorkshopDirectory;
import com.xen.spring.db_client.service.ProductionPlanService;
import com.xen.spring.db_client.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskOneController {

    @Autowired
    private ProductionPlanService planService;

    @Autowired
    private WorkshopService workshopService;

    @RequestMapping("/taskOneVariantOne")
    public String taskOneVariantOne(HttpServletRequest request,
                                    Model model) {
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        if (Addition.taskOneHasParameters(month, year, model)) {
            List<ProductionPlan> plan = planService.taskOneVariantOne(month, Integer.parseInt(year));
            model.addAttribute("plan", plan);
        }
        return "task-1";
    }


    @RequestMapping("/taskOneVariantTwo")
    public String taskOneVariantTwo(HttpServletRequest request, Model model){
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        if (Addition.taskOneHasParameters(month, year, model)) {
            List<ProductionPlan> plan = planService.getPlan();
            List<ProductionPlan> resultPlan = new ArrayList<>();
            for (ProductionPlan row : plan) {
                if (row.getPpId().getReleaseMonth().equals(month) && row.getPpId().getReleaseYear() == Integer.parseInt(year))
                    resultPlan.add(row);
            }
            model.addAttribute("plan", resultPlan);
        }
        return "task-1";
    }


    @RequestMapping("/taskOneVariantThree")
    public String taskOneVariantThree(HttpServletRequest request, Model model) {
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        if (Addition.taskOneHasParameters(month, year, model)) {
            List<WorkshopDirectory> wd = workshopService.getAllWorkshops();
            ArrayList<ProductionPlan> result = new ArrayList<>();
            for (WorkshopDirectory row : wd) {
                List<ProductionPlan> plan = row.getPlanList();
                for (ProductionPlan p : plan) {
                    if (p.getPpId().getReleaseYear() == Integer.parseInt(year) && p.getPpId().getReleaseMonth().equals(month))
                        result.add(p);
                }
            }
            model.addAttribute("result", result);
        }
        return "task-1";
    }

}

