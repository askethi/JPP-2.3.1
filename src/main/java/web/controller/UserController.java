package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", us.listUsers());
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        us.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", us.getUserById(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @RequestParam("id") Long id) {
        us.updateUserById(user, id);
        return "redirect:/users";
    }

    @GetMapping("/")
    public String show(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", us.getUserById(id));
        return "users/show";
    }
}
