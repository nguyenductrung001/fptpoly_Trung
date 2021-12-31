package com.pt15305ud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.pt15305ud.entity.Order;
import com.pt15305ud.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService _oSer;

	@PostMapping
	public Order create(@RequestBody JsonNode orderData) {
		return _oSer.create(orderData);
	}

}
