package com.salimramirez.civabusapi.repository;

import com.salimramirez.civabusapi.entity.BusBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusBrandRepository extends JpaRepository<BusBrand, Long> {

}
