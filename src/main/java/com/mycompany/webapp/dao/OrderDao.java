package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.OrderItem;
import com.mycompany.webapp.dto.OrderList;
import com.mycompany.webapp.dto.OrderState;

@Mapper
public interface OrderDao {
	public OrderList selectOrderList(String mid);
	public OrderList getOrderListByOid(String oid);
	public List<OrderItem> getOrderItemsByOid(String oid);
	public OrderList getOrderListByMid(String mid);
	public List<String> getOidsByMid(String mid);
	public List<OrderState> getOstatusByMid(String mid);
	public OrderState getTotalOstatusByMid(String mid);
	public int createOrderItem(OrderItem orderItem);
	public int createOrderList(OrderList orderList);
}
