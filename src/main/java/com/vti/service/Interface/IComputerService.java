package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Computer;

@Service
@Component
public interface IComputerService {
	List<Computer> getAllComputers();
	
	public Computer findByComputerId(int computerId);
}
