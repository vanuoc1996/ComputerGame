package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.entity.LineItem;
import com.vti.entity.Player;

@Service
@Component
public interface ILineItemService {
	List<LineItem> getAllLineItems();
	
	void creatLineItem(LineItem lineItem);
}
