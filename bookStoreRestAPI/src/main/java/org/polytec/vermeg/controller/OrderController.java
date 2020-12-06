package org.polytec.vermeg.controller;

import java.util.List;

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

	@RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		 model.addAttribute("Order", this.orderService.getOrder(id));
	        model.addAttribute("listOforders", this.orderService.getAllOrders());
	        return "orderDetails";
	}

	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrder(id);
		 return "redirect:/getAllOrders";

	}	
	
	
}
