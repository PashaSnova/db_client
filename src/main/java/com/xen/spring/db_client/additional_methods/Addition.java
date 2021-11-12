package com.xen.spring.db_client.additional_methods;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class Addition {

    public boolean taskOneHasParameters(String month, String year, Model model) {
        if (month == null || year == null || month.equals("") || year.equals(""))
            model.addAttribute("label", "Пожалуйста, введите месяц и год");
        else
            model.addAttribute("label", month + ", " +  year);
        return !(month == null || year == null || month.equals("") || year.equals(""));
    }
}
