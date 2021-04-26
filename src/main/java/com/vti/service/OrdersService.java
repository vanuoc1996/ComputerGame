package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Enum.OrderStatus;
import com.vti.dto.OrdersCreatDTO;
import com.vti.entity.Computer;
import com.vti.entity.LineItem;
import com.vti.entity.Orders;
import com.vti.entity.PlayTime;
import com.vti.entity.Player;
import com.vti.repository.IOrdersRepository;
import com.vti.service.Interface.IComputerService;
import com.vti.service.Interface.ILineItemService;
import com.vti.service.Interface.IOrdersService;
import com.vti.service.Interface.IPlayTimeService;
import com.vti.service.Interface.IPlayerService;

@Service
public class OrdersService implements IOrdersService {
	@Autowired
	private IOrdersRepository ordersRepository;

	@Autowired
	private IPlayerService playerService;

	@Autowired
	private ILineItemService lineItemService;
	
	@Autowired
	private IPlayTimeService playTimeService;
	
	@Autowired
	private IComputerService computerService;

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	@Override
	public void creatOrder(OrdersCreatDTO ordersDTO) {
		Player player;
		LineItem lineItem;
		Orders orders;
		PlayTime playTime;
		Computer computer;

		player = playerService.findbyPlayerId(ordersDTO.getPlayerId());
		int employeeId = ordersDTO.getEmployeeId();
		orders = new Orders(player, employeeId);
		ordersRepository.save(orders);
		int orderId = ordersRepository.save(orders).getOrderId();
	
		lineItem = new LineItem(orderId);
		lineItemService.creatLineItem(lineItem);

		computer = computerService.findByComputerId(ordersDTO.getComputerId());
		playTime = new PlayTime(computer,player, orderId);
		playTimeService.creatPlayTime(playTime);
	}

	@Override
	public void payForOrder(int orderId) {
		Orders order = ordersRepository.findById(orderId).get();
		order.setOrderStatus(OrderStatus.PAID);
		playTimeService.payForOrder(orderId);
		ordersRepository.save(order);
	}

	@Override
	public void setMoneyForOrder(int orderId, PlayTime playtime) {
		Orders orders = ordersRepository.findById(orderId).get();
		orders.setTotal(playtime.getPriceTotal());
		ordersRepository.save(orders);
	}

}
