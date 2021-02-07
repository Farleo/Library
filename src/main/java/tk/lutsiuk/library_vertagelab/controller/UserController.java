package tk.lutsiuk.library_vertagelab.controller;

import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "Get certain user by id")
	public User getUser(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@GetMapping(value = "/all")
	@ApiOperation(value = "Return all user")
	public List<User> getAllUser() {
		return userService.findAllUser();
	}
	
	@PostMapping(value = "/add")
	@ApiOperation(value = "Create new user")
	public void addNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Delete user")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	
	@PutMapping(value = "/edit/{id}")
	@ApiOperation(value = "Update user details")
	public void editUser(@PathVariable Long id, @RequestBody User user) {
		userService.editUser(id, user);
	}

}
