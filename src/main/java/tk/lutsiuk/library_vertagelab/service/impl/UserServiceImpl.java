package tk.lutsiuk.library_vertagelab.service.impl;


import org.springframework.stereotype.Service;
import tk.lutsiuk.library_vertagelab.entity.User;
import tk.lutsiuk.library_vertagelab.repository.UserRepository;
import tk.lutsiuk.library_vertagelab.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public void addNewUser(User user) {
		Optional<User> userDB = Optional.ofNullable(userRepository.findByUserName(user.getUserName()));
		if (userDB.isEmpty()) {
			userRepository.save(user);
		} else {
			throw new IllegalStateException("Username is already used");
		}
	}
	
	@Override
	public void deleteUser(Long id) {
		User userDB = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("There is no user that you want to delete"));
		userRepository.delete(userDB);
	}
	
	@Override
	public void editUser(Long id, User user) {
		User userDB = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("There is no user that you want to edit"));
		userDB.setUserName(user.getUserName());
		userRepository.save(userDB);
	}
}
