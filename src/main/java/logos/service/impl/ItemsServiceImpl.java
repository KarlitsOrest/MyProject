package logos.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.entity.ItemsModel;
import logos.repository.ItemsRepository;
import logos.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	
	@Autowired ItemsRepository itemsRepository;
	
	@Override
	public void saveItems(ItemsModel itemsModel) {
		itemsRepository.save(itemsModel);
		
	}

	@Override
	public void updateItems(ItemsModel itemsModel) {
		itemsRepository.save(itemsModel);
		
	}

	@Override
	public ItemsModel getItemsById(int id) {
		
		return itemsRepository.findOne(id);
	}

	@Override
	public List<ItemsModel> findAllItems() {
		
		return itemsRepository.findAll();
	}

}
