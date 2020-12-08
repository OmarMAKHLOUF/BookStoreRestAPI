package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.model.Order;
import org.polytec.vermeg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/Order")
public class OrderController {



 

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "lll ";
    }
	
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Order> getOrders() {
		
		List<Order> listOfOrders = orderService.getAllOrders();
		
		return listOfOrders;
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrder(id);
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addOrder(@RequestBody Order order) {	
		
		orderService.addOrder(order);
		return "redirect:/getAllOrders";
	}

	@RequestMapping(value = "/updateOrder ", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateOrder(@RequestBody Order order) {
		this.orderService.updateOrder(order);
        return "orderDetails";
}
	
	
 

	 
	
	@RequestMapping(method = RequestMethod.DELETE, value = " /delete")
	public void delete(@RequestBody Order order) {
		this.orderService.delete(order);
	}
	
	
	
	
	
}
