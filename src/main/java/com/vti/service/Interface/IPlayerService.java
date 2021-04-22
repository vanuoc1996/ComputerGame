package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.dto.PlayerCreatDTO;
import com.vti.entity.Player;
import com.vti.pageSetup.Paging;
import com.vti.pageSetup.Sorting;
import com.vti.view.FilterPlayer;
import com.vti.view.ViewPlayer;

@Service
@Component
public interface IPlayerService {
	List<Player> getAllPlayers();

	void creatPlayer(PlayerCreatDTO player);
	
	void inputMoney(String name, int money);
	
	List<ViewPlayer> viewDetailPlayer(String name, FilterPlayer filter, Paging paging, Sorting sorting);
	
	void updatePasswordByUserName(String userName, String oldPassword, String newPassword);
	
	Player findbyPlayerId(int playerId);
}
