package tk.lutsiuk.library_vertagelab.service;

import tk.lutsiuk.library_vertagelab.entity.User;

import java.util.List;

public interface UserService {
	User findUserById(Long id);
	
	List<User> findAllUser();
}
