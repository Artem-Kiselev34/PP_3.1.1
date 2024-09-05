package ru.kiselev.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kiselev.model.User;
import ru.kiselev.service.UserService;

import java.util.List;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String getUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }
//
//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable("id") Integer id, Model model) {
//        if (id != null) {
//            User user = userService.readUser(id);
//            model.addAttribute("user", user);
//        }
//        return "user";
//    }
//
//    @GetMapping ("/add")
//    public String addUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "add-user";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.createUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editUserForm(@PathVariable("id") Integer id, Model model) {
//        User user = userService.readUser(id);
//        model.addAttribute("user", user);
//        return "edit-user";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String editUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
//        user.setId(id);
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
//    @GetMapping("/{id}/delete")
//    public String deleteUser(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//}


//@Controller
//@RequestMapping("/users")
//public class UserController {
//    @GetMapping
//    public String getUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users"; // Имя шаблона
//    }
//}
//@Controller
//public class HomeController {
//    @GetMapping("/")
//    public String home() {
//        return "redirect:/users";
//    }
//}

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam("id") Long id, Model model) {
        if (id != null) {
            User user = userService.readUser(id);
            model.addAttribute("user", user);
        }
        return "user";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

        @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.createUser(user);
        return "redirect:/users";
    }



    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") long id, @ModelAttribute("user") User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


//@RestController
//public class HomeController {
//    @GetMapping("/")
//    public String home() {
//        return "Hello, World!";
//    }
//}
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String getUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }
//
//    @GetMapping("/user")
//    public String getUserById(@RequestParam("id") Long id, Model model) {
//        if (id != null) {
//            User user = userService.readUser(id);
//            model.addAttribute("user", user);
//        }
//        return "user";
//    }
//
//    @GetMapping("/add")
//    public String addUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "add-user";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.createUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/edit")
//    public String editUserForm(@RequestParam("id") long id, Model model) {
//        User user = userService.readUser(id);
//        model.addAttribute("user", user);
//        return "edit-user";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@RequestParam("id") long id, @ModelAttribute("user") User user) {
//        user.setId(id);
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/delete")
//    public String deleteUser(@RequestParam("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
//}
