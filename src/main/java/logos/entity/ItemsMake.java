package logos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import logos.validator.IfExistItemsMaker;



@Entity
@Table(name="items_make")

public class ItemsMake extends BaseEntity {
	
public ItemsMake() {
		
	}

@IfExistItemsMaker(message="This model already exists")
private String title;
	


	@OneToMany(mappedBy="itemsMake", cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	List<ItemsModel> itemss = new ArrayList<>();

	public List<ItemsModel> getItemss() {
		return itemss;
	}

	public void setItemss(List<ItemsModel> itemss) {
		this.itemss = itemss;
	}
	public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}
	

}
