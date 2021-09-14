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
    
    /**
     * 회원가입 요청 시, 호출 화면
     * 
     * @return signUp화면
     */
    @GetMapping(value = "/signUp")
    public String signUpForm() {
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
    	
    	if(bindingResult.hasErrors()) {
    		log.debug("===== [Error] =====");
    		log.debug(bindingResult.getAllErrors().toString());
    		log.debug("===================");
    	}
    	
    	User user = getBindUserVO(form);
    	userService.signUp(user);
    	
    	return "/redirect:";
    }
    
    /**
     * Form에서 넘어온 값을 User 엔티티에 매핑하여 반환하는 메소드
     * 
     * @param 회원가입 form VO
     */
	private User getBindUserVO(SignUpForm form) {
		User user = new User();
    	
    	user.setEmail(form.getEmail());
    	user.setName(form.getName());
    	user.setAge(form.getAge());
    	user.setGender(form.getGender());
    	
    	return user;
	}

}
