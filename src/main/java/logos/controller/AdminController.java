package logos.controller;

//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

//import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import logos.domain.CreateItemsRequest;
import logos.domain.EditItemsRequest;
import logos.entity.Custom;
import logos.entity.ItemsMake;
import logos.entity.ItemsModel;
//import logos.entity.Product;
import logos.entity.UserEntity;
import logos.entity.enumeration.BodyType;
import logos.entity.enumeration.Memory;
import logos.mail.Mail;
import logos.mapper.ItemsModelMapper;
import logos.service.CustomService;
import logos.service.EmailService;
import logos.service.ItemsService;
import logos.service.MakeService;

import logos.service.UserService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("editItemsModel")
public class AdminController {
	
	@Autowired
	private ItemsService itemsService; 
	@Autowired
	private MakeService makeService;
	
	@Autowired 
	private CustomService customService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;

	@GetMapping("/admin")
	public String showprofile(Principal principal, Model model) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		return"admin/admin-profile";
	}
	
	@GetMapping("/additems")
	public String showAddItems(Model model) {

		
		model.addAttribute("modelRequest", new CreateItemsRequest() );
		
		
		List<ItemsMake> make = makeService.findAllItemsMake();
		model.addAttribute("makers", make);
		
		model.addAttribute("typeMemory", Memory.values());
		model.addAttribute("bodyModel", BodyType.values());
		model.addAttribute("itemsModel", new ItemsModel());
		
		
		
		return"admin/add_items";
	}
	@PostMapping("/addItems")
	public String  saveItems(@ModelAttribute("modelRequest") CreateItemsRequest request) throws IOException{


		System.out.println("dfhvssfghj87gkveolhfisef;isoehj;");
		
		ItemsModel itemsModel = new ItemsModel();
		itemsModel = ItemsModelMapper.addRequestToItemsModel(request);
		System.out.println(itemsModel.toString());
		
		itemsService.saveItems(itemsModel);
		

		
		return"redirect:/admin/admin";
	}
	@GetMapping("/addMaker")
	public String showAddMaker(Model model) {
		model.addAttribute("itemsMake", new ItemsMake());
		return"admin/add_maker";
	}

	@PostMapping("/addMaker")
	public String addMaker(@ModelAttribute("itemsMake") @Valid ItemsMake itemsMake , BindingResult result) {
		
		if(result.hasErrors()) {
			return"admin/add_maker";
			
		}
		
		
		makeService.saveMaker(itemsMake);
		return"redirect:/admin/admin";
		
	}
	
	
//	@GetMapping("/addProduct")
//	public String showAddProduct(Model model) {
//		model.addAttribute("modelRequest", new Product());
//		return"admin/add_product";
//	}
//	@PostMapping("/addProduct")
//	public String saveProduct(@ModelAttribute("productModel") Product product) {
//
//		productService.saveProduct(product);
//		return"redirect:/admin/admin";
//	}

	
	@GetMapping("/custom")
	public String showCustonPage(Model model) {
		List<Custom> customList = customService.findAllCustomByStatus(false);
		model.addAttribute("customListModel", customList);
		return"admin/custom";
	}
	@PostMapping("/custom")
	public String confirmedCuston() {
		return"redirect:/admin/custom";
	}
	@GetMapping("/edit/{itemsId}")
	public String editItems(@PathVariable("itemsId") int itemsId, Model model, Principal pritipal ) {
		ItemsModel itemsModel = itemsService.getItemsById(itemsId);
		
		if(itemsId!=itemsModel.getId()) {
			return"redirect:/admin/itemsList";
		}
		EditItemsRequest request = ItemsModelMapper.itemsToRequest(itemsModel);
//		List<Product> product = productService.findAllProduct();
//		model.addAttribute("productList", product);
		model.addAttribute("editItemsModel", request);
		
		return"admin/edit_items";
	}
	
	@PostMapping("/edit/{itemsId}")
	public String saveEditItemsModel(@ModelAttribute("editItemsModel") EditItemsRequest request, @PathVariable("itemsId") int itemsId ) {
		
		ItemsModel itemsModel = ItemsModelMapper.editItemsToEntity(request);
		
		itemsService.saveItems(itemsModel);
		return"redirect:/admin/admin";
	}
	
	@GetMapping("/confirm/{customId}")
	public String confirmOrder(@PathVariable("customId") int customId) {
		Custom custom = customService.findOneCustonById(customId);
		
		if(customId!=custom.getId()) {
			return"redirect:/admin/custom";
		}
		
		custom.setStatus(true);
		customService.saveCustom(custom);
		UserEntity user = custom.getUser();
		ItemsModel modelItems = custom.getItemsmodel();
		Mail mail = new Mail();
		mail.setTo(user.getEmail());
		mail.setSubject("Custom");
		mail.setContent("your items " + modelItems.getItemsMake().getTitle() + modelItems.getModel()+"  is available  "+"  items cost  "+ modelItems.getPrice()+"$");
		emailService.sendMessage(mail);
		return"redirect:/admin/custom";
	}
//	@GetMapping("/add")
//	public String showAdd(Model model) {
//		model.addAttribute("modelRequest", new ItemsModel());
//		model.addAttribute("memory", Memory.values());
//		return"add_product";
//		
//	}
	
	
	@GetMapping("/items_list")
	public String test(Model model) throws IOException {
		List<ItemsModel> list = itemsService.findAllItems();
		
		model.addAttribute("itemsList",list);
		return "admin/items_list";
	}
	


	
}

