package logos.service;

import java.util.List;

import logos.entity.ItemsModel;

public interface ItemsService {
	
	void saveItems(ItemsModel itemsmodel);
	
	void updateItems(ItemsModel itemsmodel);
	
	ItemsModel getItemsById(int id);
	
	List<ItemsModel> findAllItems();
	
}
