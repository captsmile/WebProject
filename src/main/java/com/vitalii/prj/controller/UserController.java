package com.vitalii.prj.controller;

import com.vitalii.prj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById( @PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

}
