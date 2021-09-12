package com.study.seeuinthemiddle.controller.user;

import com.study.seeuinthemiddle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getAllUsers")
    public String getAllUsers(Model model){

//        List<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);

        return "";
    }

    @PostMapping(value = "/signUpUser")
    public void signUpUser(BindingResult bindingResult) {
        // userForm 은 어떻게 가져올지 추후 작성.
        // userService.join();
    }

}
