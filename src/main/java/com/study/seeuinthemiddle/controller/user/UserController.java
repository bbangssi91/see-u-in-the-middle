package com.study.seeuinthemiddle.controller.user;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.seeuinthemiddle.domain.User;
import com.study.seeuinthemiddle.formVO.user.SignUpForm;
import com.study.seeuinthemiddle.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getAllUsers")
    public String getAllUsers(Model model){

//        List<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);

        return "";
    }
    
    @GetMapping(value = "/findUser")
    public void findAll() {
    	userService.findAll();
    }
    
    
    
    /**
     * 회원가입 요청 시, 호출 화면
     * 
     * @return signUp화면
     */
    @GetMapping(value = "/signUp")
    public String signUpForm(Model model) {
    	model.addAttribute("form", new SignUpForm());
    	
    	return "/users/signUp";
    }
    
    /**
     * 회원가입
     * 
     * @param userForm
     * @param bindingResult
     * 
     * @return
     */
    @PostMapping(value = "/signUp")
    public String signUpUser(@Valid SignUpForm form, BindingResult bindingResult) {
    	System.out.println("아");
    	System.out.println("아아" + form.getAge());
    	    	
    	if(bindingResult.hasErrors()) {
    		log.debug("===== [Error] =====");
    		log.debug(bindingResult.getAllErrors().toString());
    		log.debug("===================");
    	}
    	
    	
    	
    	User user = User.fillSignUp(form);
    	userService.signUp(user);
    	
    	return "/redirect:";
    }

}
