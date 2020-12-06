package org.polytec.vermeg.service;

 import java.util.List;

import org.polytec.vermeg.dao.UserDAO;
import org.polytec.vermeg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")

public class UserService {

	@Autowired
	UserDAO UserDao;
	//affiche
	@Transactional
	public List<User> getAllUsers() {
		return UserDao.getAllUsers();
	}
	//get 
	@Transactional
	public User getUser(int id) {
		return UserDao.getUser(id);
	}
	//ajout
	@Transactional
	public void addUser(User user) {
		UserDao.addUser(user);
	}
	//update
	@Transactional
	public void updateUser(User user) {
		UserDao.updateUser(user);

	}
	//delete
	@Transactional
	public void deleteUser(int id) {
		UserDao.deleteUser(id);
	}
}
