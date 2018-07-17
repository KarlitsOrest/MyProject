package logos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="custom")

public class Custom  extends BaseEntity{
	
	private boolean status;
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	public Custom(boolean status, UserEntity user, ItemsModel itemsmodel) {
		super();
		this.status = status;
		this.user = user;
		this.itemsmodel = itemsmodel;
	}

	public Custom() {
		// TODO Auto-generated constructor stub
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ItemsModel getItemsmodel() {
		return itemsmodel;
	}

	public void setItemsmodel(ItemsModel itemsmodel) {
		this.itemsmodel = itemsmodel;
	}

	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="model_id")
	private ItemsModel itemsmodel;

	

}

