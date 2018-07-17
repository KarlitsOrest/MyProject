package logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logos.entity.Custom;
import logos.repository.CustomRepository;
import logos.service.CustomService;

@Service
public class CustomServiceImpl implements CustomService {

	@Autowired
	private CustomRepository customRepository;
	
	@Override
	public void saveCustom(Custom custom) {
		customRepository.save(custom);
		
	}

	@Override
	public List<Custom> findAllCustom() {
		
		return customRepository.findAll();
	}

	@Override
	public List<Custom> findAllCustomByStatus(boolean status) {
		
		return  customRepository.findCustomByStatus(false);
	}

	@Override
	public Custom findOneCustonById(int id) {
		
		return customRepository.findOne(id);
	}

	@Override
	public List<Custom> findUserCustoms(boolean status, int userId) {
		
		return customRepository.findUserCustom(status, userId);
	}

}

