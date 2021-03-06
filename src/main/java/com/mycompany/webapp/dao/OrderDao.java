package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.controller.OrderController;
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
	public OrderList getCurrentOrderList(String oid);
	public int getCurrentOid();
	public int cancelOrder(String oid);
	public List<String> selectOrderListByMidOdate(@Param("mid") String mid, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
