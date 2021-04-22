package com.vti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.entity.PlayTime;
import com.vti.repository.IPlayTimeRepository;
import com.vti.service.Interface.IPlayTimeService;

@Service
public class PlayTimeService implements IPlayTimeService {
	@Autowired
	IPlayTimeRepository playTimeRepository;

	@Override
	public List<PlayTime> getAllPlayTime() {
		return playTimeRepository.findAll();
	}

	@Override
	public void creatPlayTime(PlayTime playTime) {
		playTimeRepository.save(playTime);
	}
}
