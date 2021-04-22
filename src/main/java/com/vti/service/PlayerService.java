package com.vti.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.vti.dto.PlayerCreatDTO;
import com.vti.entity.Person;
import com.vti.entity.Player;
import com.vti.pageSetup.Paging;
import com.vti.pageSetup.Sorting;
import com.vti.repository.IPlayerRepository;
import com.vti.service.Interface.IPersonService;
import com.vti.service.Interface.IPlayerService;
import com.vti.view.FilterPlayer;
import com.vti.view.ViewPlayer;

@Service
public class PlayerService implements IPlayerService {
	@Autowired
	private IPlayerRepository playerRepository;
	
	@Autowired
	private IPersonService personService;

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public void creatPlayer(PlayerCreatDTO playerDTO) {
		personService.creatPerson(playerDTO.toEntity());
		Person person = personService.findByUserName(playerDTO.getUserName());
		Player player = new Player(person, playerDTO.getPhoneNumber());
		playerRepository.save(player);
	}

	@Override
	public void inputMoney(String name, int money) {
		Person person = personService.findByUserName(name);
		Player player = playerRepository.findByPerson(person);
		int toMinutes = (int) Math.round((money * 0.006));
		int updateMinutes = player.getPlayHours() + toMinutes;
		player.setPlayHours(updateMinutes);
		playerRepository.save(player);
	}

	@Override
	public List<ViewPlayer> viewDetailPlayer(String name, FilterPlayer filter, Paging paging, Sorting sorting) {

		// Validate search
		if (name == null) {
			name = "";
		}
		// Validate Sort
		Sort sortable = null;
		if (sorting.getSortField() == null || sorting.getSortField().equals("")) {
			sorting.setSortField("customerId");
		}
		if (sorting.getSortType() == null || sorting.getSortType().equals("")) {
			sorting.setSortType("ASC");
		}
		if (!sorting.getSortType().equals("DESC") || sorting.getSortType() == null) {
			sortable = Sort.by(sorting.getSortField()).ascending();
		} else {
			sortable = Sort.by(sorting.getSortField()).descending();
		}

		// Validate paging
		if (paging.getPageNumber() == 0) {
			paging.setPageNumber(1);
			;
		}
		if (paging.getPageSize() == 0) {
			paging.setPageSize(5);
		}
		int page = paging.getPageNumber();
		int size = paging.getPageSize();

		// Validate filter
		if (filter.getMinPlayHours() == 0) {
			filter.setMinPlayHours(0);
		}
		if (filter.getMaxPlayHours() == 0) {
			filter.setMaxPlayHours(Integer.MAX_VALUE);
		}
		int minPlayHours = filter.getMinPlayHours();
		int maxPlayHours = filter.getMaxPlayHours();
		try {
			// ,PageRequest.of((page - 1), size, sortable)
			List<ViewPlayer> detail = playerRepository.viewDetailPlayer(name, minPlayHours, maxPlayHours);
			return detail;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void updatePasswordByUserName(String userName, String oldPassword, String newPassword) {
		personService.updatePasswordByUserName(userName, oldPassword, newPassword);
	}

	@Override
	public Player findbyPlayerId(int playerId) {
		return playerRepository.findById(playerId).get();
	}

}
