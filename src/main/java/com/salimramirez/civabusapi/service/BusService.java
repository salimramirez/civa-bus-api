package com.salimramirez.civabusapi.service;

import com.salimramirez.civabusapi.dto.BusResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusService {
    Page<BusResponseDto> findAllBuses(Pageable pageable);
    BusResponseDto findBusById(Long id);
}
