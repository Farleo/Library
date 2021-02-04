package tk.lutsiuk.library_vertagelab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.lutsiuk.library_vertagelab.entity.User;
import tk.lutsiuk.library_vertagelab.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@RequestMapping(value = "/all")
	public List<User> getAllUser() {
		return userService.findAllUser();
	}
}
