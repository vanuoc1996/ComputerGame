package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.entity.LineItem;
import com.vti.repository.ILineItemRepository;
import com.vti.service.Interface.ILineItemService;

@Service
public class LineItemService implements ILineItemService{
	@Autowired
	ILineItemRepository lineItemRepository;

	@Override
	public List<LineItem> getAllLineItems() {
		return lineItemRepository.findAll();
	}

	@Override
	public void creatLineItem(LineItem lineItem) {
		lineItemRepository.save(lineItem);
	}
	
}
