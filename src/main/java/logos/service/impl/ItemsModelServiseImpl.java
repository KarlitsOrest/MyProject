package logos.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.entity.ItemsMake;
import logos.repository.ItemsMakerRepository;
import logos.service.ItemsMakerService;

@Service
public class ItemsModelServiseImpl implements ItemsMakerService {
	@Autowired
	ItemsMakerRepository makerRepository;

	@Override
	public List<ItemsMake> findAll() {
		
		return makerRepository.findAll();
	}

}
