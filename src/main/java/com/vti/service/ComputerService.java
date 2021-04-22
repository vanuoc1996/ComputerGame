package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.entity.Computer;
import com.vti.repository.IComputerRepository;
import com.vti.service.Interface.IComputerService;

@Service
public class ComputerService implements IComputerService{
	@Autowired
	IComputerRepository computerRepository;

	@Override
	public List<Computer> getAllComputers() {
		return computerRepository.findAll();
	}

	@Override
	public Computer findByComputerId(int computerId) {
		return computerRepository.findById(computerId).get();
	}
}
