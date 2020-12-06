package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.OrderDAO;
import org.polytec.vermeg.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OrderService")
public class OrderService {

	@Autowired
	OrderDAO OrderDao;
	//affiche
	@Transactional
	public List<Order> getAllOrders() {
		return OrderDao.getAllOrders();
	}
	//get 
	@Transactional
	public Order getOrder(int id) {
		return OrderDao.getOrder(id);
	}
	//ajout
	@Transactional
	public void addOrder(Order order) {
		OrderDao.addOrder(order);
	}
	//update
	@Transactional
	public void updateOrder(Order order) {
		OrderDao.updateOrder(order);

	}
	//delete
	@Transactional
	public void deleteOrder(int id) {
		OrderDao.deleteOrder(id);
	}
	
}
