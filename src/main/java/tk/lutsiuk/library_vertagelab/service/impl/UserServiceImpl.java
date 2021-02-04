package tk.lutsiuk.library_vertagelab.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.lutsiuk.library_vertagelab.entity.User;
import tk.lutsiuk.library_vertagelab.repository.UserRepository;
import tk.lutsiuk.library_vertagelab.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
}
