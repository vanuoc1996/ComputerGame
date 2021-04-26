package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.dto.OrdersCreatDTO;
import com.vti.entity.Orders;
import com.vti.entity.PlayTime;

@Service
@Component
public interface IOrdersService {
	public List<Orders> getAllOrders();

	public void creatOrder(OrdersCreatDTO ordersDTO);
	
	public void payForOrder(int orderId);
	
	public void setMoneyForOrder(int orderId, PlayTime playtime);
}
