package com.salimramirez.civabusapi.service;

import com.salimramirez.civabusapi.dto.BusResponseDto;

import java.util.List;

public interface BusService {
    List<BusResponseDto> findAllBuses();
    BusResponseDto findBusById(Long id);
}
