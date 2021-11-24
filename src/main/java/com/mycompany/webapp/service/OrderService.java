package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.OrderDao;
import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.OrderItem;
import com.mycompany.webapp.dto.OrderList;

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
	
	public List<String> getOidsByMid(String mid){
		return orderDao.getOidsByMid(mid);
	}
	
	/*public List<OrderItem> getOrderItemsByMid(String mid) {
		return orderDao.getOrderItemsByMid(mid);
	}*/

}
