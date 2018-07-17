package logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import logos.entity.UserEntity;
import logos.repository.UserRepository;
import logos.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		
		entity.setPassword(passwordEncoder.encode(password));
		userRepository.save(entity);
	}

	@Override
	public UserEntity findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void updateUser(UserEntity entity) {
		userRepository.save(entity);
		
	}

}
