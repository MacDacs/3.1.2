package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class UserController {
    private ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping
    public String users(ModelMap model) {
        model.addAttribute("userList", serviceUser.getUsers());
        return "users";
    }

    @GetMapping("/add")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        serviceUser.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/userID")
    public String userID(@RequestParam("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("userID", serviceUser.getUser(id));
        return "userID";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("id") int id) {
        serviceUser.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", serviceUser.getUser(id));
        return "userEdit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") User user) {
        serviceUser.updateUser(user, id);
        return "redirect:/";
    }


}
