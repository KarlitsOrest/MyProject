package logos.domain;

import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.web.multipart.MultipartFile;

import logos.entity.ItemsMake;
// import logos.entity.Product;
import logos.entity.enumeration.BodyType;
import logos.entity.enumeration.Memory;

public class CreateItemsRequest {
	
	@NotEmpty private String model;
	@NotEmpty private int price;
	@NotEmpty private String year;
//	@NotEmpty private String options;
//	@NotEmpty private String descriptions;
//	@NotEmpty private String color;
//	@NotEmpty private Product product;
//	@NotEmpty private ItemsMake itemsMake;
	@NotEmpty private BodyType bodyType;
	@NotEmpty private Memory memory;
	@NotEmpty private String image;
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
//	public String getOptions() {
//		return options;
//	}
//	public void setOptions(String options) {
//		this.options = options;
//	}
//	public String getDescriptions() {
//		return descriptions;
//	}
//	public void setDescriptions(String descriptions) {
//		this.descriptions = descriptions;
//	}
//	public String getColor() {
//		return color;
//	}
//	public void setColor(String color) {
//		this.color = color;
//	}
	
	
	
	
//	public Product getProduct() {
//		return product;
//	}
//	public void setProduct(Product product) {
//		this.product = product;
//	}
	
	
//	public ItemsMake getItemsMake() {
//		return itemsMake;
//	}
//	public void setItemsMake(ItemsMake itemsMake) {
//		this.itemsMake = itemsMake;
//	}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CreateItemsRequest(String model, int price, String year, String options, String descriptions, String color,
		//	Product product, 
			ItemsMake itemsMake, BodyType bodyType, Memory memory, String image) {
		super();
		this.model = model;
		this.price = price;
		this.year = year;
	//	this.options = options;
	//	this.descriptions = descriptions;
	//	this.color = color;
	//	this.product = product;
	//	this.itemsMake = itemsMake;
		this.bodyType = bodyType;
		this.memory = memory;
		this.image = image;
	}
	public CreateItemsRequest() {
		
	}
	@Override
	public String toString() {
		return "CreateItemsRequest [model=" + model + ", price=" + price + ", year=" + year + ",  bodyType=" + bodyType + ", memory=" + memory + ", image=" + image
				+ ", getModel()=" + getModel() + ", getPrice()=" + getPrice() + ", getYear()=" + getYear()
				+ ",  getBodyType()=" + getBodyType() + ", getMemory()=" + getMemory() + ", getImage()="
				+ getImage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
