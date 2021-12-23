package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class OrderState {
	private int ostatus;//0:전체, 1:결제, 2:배송, 3:배송완료, 4:구매확정, 5:구매취소
	private int count;
}
