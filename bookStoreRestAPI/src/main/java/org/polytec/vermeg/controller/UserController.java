package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.model.User;
 import org.polytec.vermeg.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		
		List<User> listOfUsers = userService.getAllUsers();
		
		return listOfUsers;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user") User user) {	
		if(user.getId_user()==0)
		{
			userService.addUser(user);
		}
		else
		{	
			userService.updateUser(user);
		}
		
		return "redirect:/getAllUsers";
	}

	@RequestMapping(value = "/updateUser ", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateOrder(@RequestBody User user) {
		this.userService.updateUser(user);
        return "userDetails";
}

	@RequestMapping(method = RequestMethod.DELETE, value = " /delete")
	public void delete(@RequestBody User user) {
		this.userService.delete(user);
	}
	
	
}
