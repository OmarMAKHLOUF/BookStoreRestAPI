package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.User;
 import org.polytec.vermeg.service.UserService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		 model.addAttribute("User", this.userService.getUser(id));
	        model.addAttribute("listOfusers", this.userService.getAllUsers());
	        return "userDetails";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		 return "redirect:/getAllUsers";

	}	
	
	
}
