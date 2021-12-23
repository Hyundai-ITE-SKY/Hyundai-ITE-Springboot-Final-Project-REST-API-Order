package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycompany.webapp.controller.OrderController;
import com.mycompany.webapp.dao.OrderDao;
import com.mycompany.webapp.dto.OrderItem;
import com.mycompany.webapp.dto.OrderList;
import com.mycompany.webapp.dto.OrderState;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	@Resource
	private OrderDao orderDao;

	public OrderList getOrderList(String mid) {
		log.info("실행");
		return orderDao.selectOrderList(mid);
	}

	public OrderList getOrderListByOid(String oid) {
		return orderDao.getOrderListByOid(oid);
	}

	public List<OrderItem> getOrderItemsByOid(String oid) {
		return orderDao.getOrderItemsByOid(oid);
	}

	public OrderList getOrderListByMid(String mid) {
		return orderDao.getOrderListByMid(mid);
	}

	public List<String> getOidsByMid(String mid) {
		return orderDao.getOidsByMid(mid);
	}

	public List<OrderState> getOstatusByMid(String mid) {
		return orderDao.getOstatusByMid(mid);
	}

	public OrderState getTotalOstatusByMid(String mid) {
		return orderDao.getTotalOstatusByMid(mid);
	}

	public int createOrderItem(OrderItem orderItem) {
		return orderDao.createOrderItem(orderItem);
	}

	@Transactional
	public OrderList createOrderList(OrderList orderList) {
		OrderList result = new OrderList();

		try {
			orderDao.createOrderList(orderList);
			String oid = String.valueOf(orderDao.getCurrentOid());
			result = orderDao.getCurrentOrderList(oid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public int cancelOrder(String oid) {
		return orderDao.cancelOrder(oid);
	}
	

	public List<String> getOrderListByMidOdate(String mid, String startdate, String enddate) {
		return orderDao.selectOrderListByMidOdate(mid, startdate, enddate);
	}
}
