package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.PlayTime;

@Service
@Component
public interface IPlayTimeService {
	List<PlayTime> getAllPlayTime();

	public void creatPlayTime(PlayTime playTime);
}
