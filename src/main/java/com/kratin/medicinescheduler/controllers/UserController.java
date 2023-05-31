package com.kratin.medicinescheduler.controllers;

import com.kratin.medicinescheduler.dto.UserDto;
import com.kratin.medicinescheduler.entities.User;
import com.kratin.medicinescheduler.services.UserService;
import jakarta.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/home"})
    public String Home() {
        return "login";
    }

    @GetMapping({"/login"})
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        User user = this.userService.checkUserExists(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/schedule";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping({"/register"})
    public String register() {
        return "register";
    }

    @PostMapping({"/register/save"})
    public String saveUser(@ModelAttribute("UserData") @Valid UserDto user, Model model) {
        User existing = this.userService.getUserByEmail(user.getEmail());
        if (existing != null) {
            model.addAttribute("error", "There is already an account registered with that email");
            return "register";
        } else {
            this.userService.saveUser(user);
            return "schedule";
        }
    }
}