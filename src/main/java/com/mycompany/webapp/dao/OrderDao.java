package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.OrderItem;
import com.mycompany.webapp.dto.OrderList;

@Mapper
public interface OrderDao {
	public OrderList selectOrderList(String mid);
	public OrderList getOrderListByOid(String oid);
	public List<OrderItem> getOrderItemsByOid(String oid);
	public OrderList getOrderListByMid(String mid);
	//public List<OrderItem> getOrderItemsByMid(String mid);
	public List<String> getOidsByMid(String mid);
}
