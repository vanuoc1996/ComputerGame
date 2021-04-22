package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.PlayTime;

@Repository
public interface IPlayTimeRepository extends JpaRepository<PlayTime, Integer> {

}
