package logos.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import logos.entity.Custom;
import logos.entity.ItemsModel;
import logos.entity.UserEntity;

import logos.service.CustomService;
import logos.service.ItemsService;
import logos.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControler {

	@Autowired private UserService userService;
	@Autowired private CustomService customServise;
	@Autowired
	private ItemsService itemsService; 
	
	@GetMapping("/profile")
	
	public String showUserPage(Principal principal, Model model) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		
		List<Custom> userItemsList = customServise.findUserCustoms(false, entity.getId());
		model.addAttribute("userItemsListModel", userItemsList);
		
		return"user/user_profile";
	}
	
	
	@GetMapping("/items_list")
	public String test(Model model) throws IOException {
		List<ItemsModel> list = itemsService.findAllItems();
		
		model.addAttribute("itemsList",list);
		return "user/items_list";
	}


}
