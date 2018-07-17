package logos.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import logos.entity.ItemsModel;
import logos.entity.Custom;
import logos.entity.UserEntity;
import logos.service.ItemsService;
import logos.service.CustomService;
import logos.service.UserService;

@Controller
@RequestMapping("/itemss")
public class ItemsController {
@Autowired private ItemsService itemsService;
@Autowired private  UserService userServise;
@Autowired private CustomService customServise;

@GetMapping("/itemslist")
private String showItemsListAdmin(Model model, Principal principal ) {
	
	UserEntity userEntity = userServise.findUserByEmail(principal.getName());
	List<ItemsModel> itemsModelList = itemsService.findAllItems();
	model.addAttribute("UserEntytiModel", userEntity);
	model.addAttribute("itemsList", itemsModelList);		
	return"items_list";
}
@GetMapping("/user/{userid}/info/{itemsid}")
public String showInfoByItems(@PathVariable("itemsid") int itemsId, @PathVariable("userid") int userId,  Model model, Principal principal) {
	ItemsModel itemsModel = itemsService.getItemsById(itemsId);
	UserEntity userEntity = userServise.findUserById(userId);
	
	if(itemsId!=itemsModel.getId()){
		return"redirect:/itemss/itemslist";
	}
	model.addAttribute("userModel", userEntity);
	model.addAttribute("itemsModelInfo", itemsModel);
	return "items-info";
}

@PostMapping("/user/{userid}/info/{itemsid}")
public String addCustom(@PathVariable("userid") int uderId,@PathVariable("itemsid") int itemsId ) {
	UserEntity userEntity = userServise.findUserById(uderId);
	ItemsModel itemsModel = itemsService.getItemsById(itemsId);
	Custom custom = new Custom();
	custom.setItemsmodel(itemsModel);
	custom.setUser(userEntity);
	custom.setStatus(false);
	customServise.saveCustom(custom);
	
	return"redirect:/user/profile";
}
@GetMapping("/user/{userid}/buy/{itemsid}")
public String buyItems(@PathVariable("userid") int userId, @PathVariable("itemsid") int itemsId, Principal principal, Model model ) {
	
	 
	UserEntity userEntity = userServise.findUserByEmail(principal.getName());
	
	ItemsModel itemsModel = itemsService.getItemsById(itemsId);
	Custom custom  = new Custom();
	custom.setItemsmodel(itemsModel);
	custom.setUser(userEntity);
	custom.setStatus(false);
	customServise.saveCustom(custom);
	return "redirect/user/profile";
}
	
}
