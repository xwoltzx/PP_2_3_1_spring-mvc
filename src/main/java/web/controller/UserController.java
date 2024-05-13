package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users";
    }
    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        userService.delete(user.getId());
        return "redirect:/users";
    }
}
