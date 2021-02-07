package tk.lutsiuk.library_vertagelab.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.lutsiuk.library_vertagelab.entity.User;
import tk.lutsiuk.library_vertagelab.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@GetMapping(value = "/all")
	public List<User> getAllUser() {
		return userService.findAllUser();
	}
	
	@PostMapping(value = "/add")
	public void addNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping(value = "/edit/{id}")
	public void editUser(@PathVariable Long id, @RequestBody User user) {
		userService.editUser(id, user);
	}

}
