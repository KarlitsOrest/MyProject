package logos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;



import logos.entity.enumeration.BodyType;
import logos.entity.enumeration.Memory;



@Entity
@Table(name="items_model")

public class ItemsModel extends BaseEntity{


	private String model;
	private int price;
	private String year;
//	private String options;//комплектація
//	private String descriptions;//опис по моелі 
//	private String color;
	@Column(columnDefinition = "LONGTEXT")
	private String image;

	


	public ItemsModel(String model, int price, String year, String options, String descriptions, String color,
			String image,  
			ItemsMake itemsMake, 
			BodyType bodyType, Memory memory, List<Custom> custom) {
		super();
		this.model = model;
		this.price = price;
		this.year = year;
//		this.options = options;
//		this.descriptions = descriptions;
//		this.color = color;
		this.image = image;
	//	this.product = product;
		this.itemsMake = itemsMake;
		this.bodyType = bodyType;
		this.memory = memory;
		this.custom = custom;
	}

	public ItemsModel() {
		
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

//	public String getOptions() {
//		return options;
//	}
//
//	public void setOptions(String options) {
//		this.options = options;
//	}
//
//	public String getDescriptions() {
//		return descriptions;
//	}
//
//	public void setDescriptions(String descriptions) {
//		this.descriptions = descriptions;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public Product getProduct() {
//		return product;
//	}
//
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

	public List<Custom> getCustom() {
		return custom;
	}

	public void setCustom(List<Custom> custom) {
		this.custom = custom;
	}

//	@ManyToOne(cascade= {
//			CascadeType.DETACH,
//			CascadeType.MERGE,
//			CascadeType.PERSIST,
//			CascadeType.REFRESH})
//	@JoinColumn(name="product_id")
//	private Product product;
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="make_id")
	private ItemsMake itemsMake;
	
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
	@Enumerated(EnumType.STRING)
	private Memory memory;

	@OneToMany(mappedBy="itemsmodel", cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List<Custom> custom;




	@Override
	public String toString() {
		return "ItemsModel [model=" + model + ", price=" + price + ", year=" + year + ",  image=" + image + ", itemsMake=" + itemsMake + ", bodyType=" + bodyType + ", memory=" + memory + ", custom=" + custom
				+ "]";
	}




	


	


}
