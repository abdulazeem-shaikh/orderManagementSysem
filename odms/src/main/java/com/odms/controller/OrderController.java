/**
 * 
 */
package com.odms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.odms.model.Order;
import com.odms.util.service.OrderService;

/**
 * @author azeem
 *
 */
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/{order}", method = RequestMethod.POST)
	public Order createOrder(@Validated @RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@RequestMapping(value = "/{order}", method = RequestMethod.GET)
	public String getOrderDetail(@RequestParam("orderId") String orderId) {
		return orderService.getOrderDetail(orderId);
	}

	@RequestMapping(value = "/{order}", method = RequestMethod.PUT)
	public Order updateOrder(@Validated @RequestBody Order order) {
		return orderService.updateOrder(order);
	}

	@RequestMapping(value = "/{order}", method = RequestMethod.DELETE)
	public String cancelOrder(@RequestParam("orderId") String orderId) {
		return orderService.cancelOrder(orderId);
	}

}
