package logos.service;

import java.util.List;

import logos.entity.ItemsMake;

public interface MakeService {
	
	void saveMaker(ItemsMake make);
	
	ItemsMake findMakeByName(String name);
	
	List<ItemsMake> findAllItemsMake();
	
}
