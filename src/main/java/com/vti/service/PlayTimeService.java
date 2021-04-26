package com.vti.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.entity.PlayTime;
import com.vti.repository.IPlayTimeRepository;
import com.vti.service.Interface.IOrdersService;
import com.vti.service.Interface.IPlayTimeService;

@Service
public class PlayTimeService implements IPlayTimeService {
	@Autowired
	IPlayTimeRepository playTimeRepository;
	
	@Autowired
	IOrdersService ordersService;

	@Override
	public List<PlayTime> getAllPlayTime() {
		return playTimeRepository.findAll();
	}

	@Override
	public void creatPlayTime(PlayTime playTime) {
		playTimeRepository.save(playTime);
	}

	@Override
	public void payForOrder(int orderId) {
		PlayTime playTime = findByOrderId(orderId);
		setInfomationToPay(playTime);
		ordersService.setMoneyForOrder(orderId, playTime);
	}

	@Override
	public PlayTime findByOrderId(int orderId) {
		return playTimeRepository.findByOrderId(orderId);
	}

	@Override
	public void setInfomationToPay(PlayTime playTime) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endTime = format.format(new Date());
		String startTime = playTime.getStartTime();
		try {
			Date endTimeToDate = format.parse(endTime);
			Date startTimeToDate = format.parse(startTime);
			long timeToPlay = (endTimeToDate.getTime() - startTimeToDate.getTime()) / (60000);
			long priceTotal = timeToPlay * playTime.getPricePerHour()/60;
			playTime.setEndTime(endTime);
			playTime.setTimeToPlay(timeToPlay);
			playTime.setPriceTotal(priceTotal);
			playTimeRepository.save(playTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
