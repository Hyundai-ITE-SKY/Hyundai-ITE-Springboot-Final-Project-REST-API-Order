package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderList {
	private String oid;
	private String mid;
	private int ozipcode;
	private String oaddress1;
	private String oaddress2;
	private Date odate;
	private String oreceiver;
	private String otel;
	private int ousedmileage;
	private int ousedcoupon;
	private int opayment;
	private int ostatus;
	private Date oaccountdeadline;
	private int odiscounted;
}
