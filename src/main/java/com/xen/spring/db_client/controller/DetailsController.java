package com.xen.spring.db_client.controller;

import com.xen.spring.db_client.entity.Detail;
import com.xen.spring.db_client.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DetailsController {

    @Autowired
    private DetailService service;


    @RequestMapping("/details")
    public String getAllDetails(Model model) {

        List<Detail> details = service.getAllDetails();
        model.addAttribute("allDetails", details);
        return "all-details";
    }

    @RequestMapping("/addDetail")
    public String addDetail(Model model) {
        Detail detail = new Detail();
        model.addAttribute("detail", detail);
        return "detail-info";
    }

    @RequestMapping("/saveDetail")
    public String saveDetail(@Valid @ModelAttribute("detail") Detail detail, BindingResult result) {
        if (result.hasErrors())
            return "detail-info";
        service.addDetail(detail);
        return "redirect:/details";
    }

    @RequestMapping("/deleteDetail")
    public String deleteDetail(@RequestParam("detailId") int id) {
        service.deleteDetail(id);
        return "redirect:/details";
    }


    @RequestMapping("/updateDetail")
    public String updateDetail(@RequestParam("detailId") int id, Model model) {
        Detail detail = service.getDetail(id);
        model.addAttribute("detail", detail);
        return "detail-info";
    }

    @ExceptionHandler
    public String handleException(Exception exception) {
        return "error-info-detail";
    }


}
