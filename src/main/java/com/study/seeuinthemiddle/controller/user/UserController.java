package com.study.seeuinthemiddle.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.seeuinthemiddle.domain.User;
import com.study.seeuinthemiddle.formVO.user.SignUpForm;
import com.study.seeuinthemiddle.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    
    /**
     * 가입된 회원 전체를 조회하는 메소드
     * 
     * @return 사용자 목록 화면
     */
    @GetMapping(value = "/userList")
    public String getAllUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        
        return "/users/userList";
    }
    
    
    /**
     * 회원가입 요청 시, 호출 화면
     * 
     * @return signUp화면
     */
    @GetMapping(value = "/signUp")
    public String signUpForm(Model model) {
    	model.addAttribute("signUpForm", new SignUpForm());
    	
    	return "/users/signUp";
    }
    
    /**
     * 회원가입 메소드
     * 
     * @param userForm
     * @param bindingResult
     * 
     * @return
     */
    @PostMapping(value = "/signUp")
    public String signUpUser(@Valid SignUpForm form, BindingResult bindingResult) {
    	
    	if(bindingResult.hasErrors()) {
    		log.debug("===== [Error] =====");
    		log.debug(bindingResult.getAllErrors().toString());
    		log.debug("===================");
    	}
    	
    	User user = User.fillSignUp(form);
    	userService.signUp(user);
    	
    	return "redirect:/";
    }
    
    @GetMapping(value = "/update/{id}/edit")
    public String getUserEditForm(@PathVariable("userId") Long userId) {
    	
    	
    	return "/users/editUser";
    }
    
    @PostMapping(value = "/update/{id}/edit")
    public String updateUser(@PathVariable("userId") Long userId, @ModelAttribute("userForm") SignUpForm userForm) {
    	
    	userService.updateUser(userId, userForm);
    	
    	
    	return null;
    }

}
