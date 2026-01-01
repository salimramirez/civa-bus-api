package com.salimramirez.civabusapi.repository;

import com.salimramirez.civabusapi.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}
