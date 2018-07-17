package logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.entity.ItemsMake;
import logos.repository.MakerRepository;
import logos.service.MakeService;

@Service
public class MakeServiceImpl implements MakeService {
	
	@Autowired
	private MakerRepository  makerRepository;
	
	@Override
	public void saveMaker(ItemsMake make) {
		makerRepository.save(make);
		
	}

	@Override
	public ItemsMake findMakeByName(String name) {
		
		return makerRepository.findMakerByName(name);
	}

	@Override
	public List<ItemsMake> findAllItemsMake() {
		
		return makerRepository.findAll();
	}

}
