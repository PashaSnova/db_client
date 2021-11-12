package com.xen.spring.db_client.additional_methods;

import org.springframework.ui.Model;

public class Addition {

    public static boolean taskOneHasParameters(String month, String year, Model model) {
        if (month == null || year == null)
            model.addAttribute("label", "Пожалуйста, введите месяц и год");
        else
            model.addAttribute("label", month + ", " +  year);
        return !(month == null || year == null);
    }
}
