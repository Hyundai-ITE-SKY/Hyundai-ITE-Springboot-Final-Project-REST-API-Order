package com.mycompany.webapp.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.OrderList;
import com.mycompany.webapp.dto.OrderState;
import com.mycompany.webapp.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	@Resource
	private OrderService orderService;

	@RequestMapping("/list")
	public OrderList test(@RequestBody OrderList orderList) {
		log.info("실행");

		return orderService.getOrderList(orderList.getMid());
	}

	/* mid로 주문 목록 가져오기 */
	@GetMapping("/orderlist")
	public List<Order> orderListByMid(@RequestBody OrderList orderList) {
		List<Order> orders = new LinkedList<>();
		
		List<String> oids = orderService.getOidsByMid(orderList.getMid());
		log.info(oids+"");
		for(String oid : oids) {
			Order order = new Order();

			order.setOrderlist(orderService.getOrderListByOid(oid));
			order.setOrderitem(orderService.getOrderItemsByOid(oid));
			orders.add(order);
		}
		
		return orders;
	}

	/* oid로 orderlist와 orderitem 가져오기 */
	@GetMapping("/orderlist/{oid}")
	public Order orderListByOid(@PathVariable String oid) {
		Order order = new Order();

		order.setOrderlist(orderService.getOrderListByOid(oid));
		order.setOrderitem(orderService.getOrderItemsByOid(oid));

		return order;
	}
	
	/* mid로 ostatus와 개수 가져오기 */
	@GetMapping("/orderstate")
	public List<OrderState> ostatusByMid(String mid) {
		List<OrderState> orderStatus = new LinkedList<OrderState>();
		
		orderStatus = (orderService.getOstatusByMid(mid));
		orderStatus.add(orderService.getTotalOstatusByMid(mid));
		
		return orderStatus;
	}
	
}