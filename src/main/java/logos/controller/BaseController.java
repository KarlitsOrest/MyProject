package logos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import logos.domain.RegisterRequest;
import logos.entity.UserEntity;
import logos.mail.Mail;
import logos.mapper.UserMapper;
import logos.service.EmailService;
import logos.service.UserService;
import logos.service.impl.RandomToken;

@Controller
public class BaseController {
	
	@Autowired private UserService userService;
	@Autowired private EmailService emailService;
	
	@GetMapping({"/", "/home"})
	public String shoHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("userModel", new RegisterRequest());
		return"register";
	}
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("userModel") RegisterRequest request) {
		
		UserEntity user = UserMapper.registerToUser(request);
		String token = RandomToken.gemerateRandom();
		user.setToken(token);
		user.setActivated(false);
		userService.saveUser(user);
		Mail mail = new Mail();
		mail.setTo(request.getEmail());
		mail.setSubject("You are seccsesfully registered");
		mail.setContent("Please verify your email adress by follow thes link: " 
				+ "http://localhost:8090/verify?token=" + token + "&userid=" + user.getId()
				);
		
		emailService.sendMessage(mail);
		return"redirect:/user/profile";
	}
	@GetMapping("/verify")
	public String verify(@RequestParam("token") String token, @RequestParam("userid") String UserIdStr ) {
		int userIdInt = Integer.valueOf(UserIdStr);
		UserEntity user = userService.findUserById(userIdInt);
		if(user.getToken().equals(token)) {
			user.setToken("");
			user.setActivated(true);
			userService.updateUser(user);
		}
		return"login";
	}
	@GetMapping("/stop/to/verifi")
	public String showStopPage() {
		return"stop";
	}
		
	@GetMapping("/info")
	public String showInfo() {
		return"info";
	}
	@GetMapping("/items_product")
	public String showItems_product() {
		return"items_product";
	}
	
	@GetMapping("/items_product/{id_p}")
	public String showItems_product(Model model, Principal principal) {
		
		UserEntity entity = userService.findUserByEmail(principal.getName()); 
		model.addAttribute("userEntity", entity);
		return"items_product";
	}

	@PostMapping("/items_product/{id_p}/")
	public String postItemsProduct() {
		
		
		
		return"redirect:/user/profile";
	} 
	
}

