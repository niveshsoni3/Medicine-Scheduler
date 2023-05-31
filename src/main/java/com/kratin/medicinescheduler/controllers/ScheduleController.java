package com.kratin.medicinescheduler.controllers;

import com.kratin.medicinescheduler.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {
    public ScheduleController() {
    }

    @GetMapping({"/schedule"})
    public String showSchedulePage(HttpSession session, Model model) {
        User user = (User)session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "schedule";
    }
}