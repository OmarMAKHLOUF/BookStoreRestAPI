package org.polytec.vermeg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.polytec.vermeg.model.Order;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {



 
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Order> getAllOrders() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Order> orderList = session.createQuery("from Order").list();
		
		for (Order b:orderList) {
			System.out.println("##### Count "+b.getId_cmd());
		}
		
		return orderList;
	}

	public Order getOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, new Integer(id));
		return order;
	}

	public Order addOrder(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(order);
		return order;
	}

	public void updateOrder(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(order);
	}

	public void deleteOrder(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Order b = (Order) session.load(Order.class, new Integer(id));
		if (null != b) {
			session.delete(b);
		}
	}	
}