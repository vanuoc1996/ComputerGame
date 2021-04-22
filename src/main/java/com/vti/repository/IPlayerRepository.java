package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vti.entity.Person;
import com.vti.entity.Player;
import com.vti.view.ViewPlayer;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

	Player findByPerson(Person person);

	@Query(value = "EXEC viewDetailPlayer @userName = :name ,@minPlayHours = :minPlayHours, @maxPlayHours = :maxPlayHours", nativeQuery = true)
	public List<ViewPlayer> viewDetailPlayer(@Param("name") String name, @Param("minPlayHours") int minPlayHours,
			@Param("maxPlayHours") int maxPlayHours);
}
