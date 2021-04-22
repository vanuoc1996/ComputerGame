package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.dto.OrdersCreatDTO;
import com.vti.entity.Orders;

@Service
@Component
public interface IOrdersService {
	public List<Orders> getAllOrders();

	public void creatOrder(OrdersCreatDTO ordersDTO);
}
