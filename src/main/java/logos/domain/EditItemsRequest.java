package logos.domain;


import org.hibernate.validator.constraints.NotEmpty;

import logos.entity.ItemsMake;
//import logos.entity.Product;
import logos.entity.enumeration.BodyType;
import logos.entity.enumeration.Memory;

public class EditItemsRequest {
	
	private int id;
	@NotEmpty private String model;
	@NotEmpty private int price;
	@NotEmpty private String year;
	@NotEmpty private String options;//комплектація
	@NotEmpty private String descriptions;//опис по моделі 
	@NotEmpty private String color;
	@NotEmpty private String image;
//	@NotEmpty private Product product;
	@NotEmpty private ItemsMake itemsMake;
	public EditItemsRequest(int id, String model, int price, String year, String options, String descriptions,
			String color, String image, //Product product,
			ItemsMake itemsMake, BodyType bodyType, Memory memory) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.year = year;
		this.options = options;
		this.descriptions = descriptions;
		this.color = color;
		this.image = image;
//		this.product = product;
		this.itemsMake = itemsMake;
		this.bodyType = bodyType;
		this.memory = memory;
	}
	public EditItemsRequest() {
		
	}
	@NotEmpty private BodyType bodyType;
	@NotEmpty private Memory memory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public Product getProduct() {
//		return product;
//	}
//	public void setProduct(Product product) {
//		this.product = product;
//	}
	public ItemsMake getItemsMake() {
		return itemsMake;
	}
	public void setItemsMake(ItemsMake itemsMake) {
		this.itemsMake = itemsMake;
	}
	public BodyType getBodyType() {
		return bodyType;
	}
	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
}
