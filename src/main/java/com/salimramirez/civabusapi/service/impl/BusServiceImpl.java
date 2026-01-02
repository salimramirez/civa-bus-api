package com.salimramirez.civabusapi.service.impl;

import com.salimramirez.civabusapi.dto.BusResponseDto;
import com.salimramirez.civabusapi.entity.Bus;
import com.salimramirez.civabusapi.exception.ResourceNotFoundException;
import com.salimramirez.civabusapi.mapper.BusMapper;
import com.salimramirez.civabusapi.repository.BusRepository;
import com.salimramirez.civabusapi.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BusResponseDto> findAllBuses(Pageable pageable) {
        return busRepository.findAll(pageable)
                .map(BusMapper::toResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public BusResponseDto findBusById(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found with ID: %d".formatted(id)));
        return BusMapper.toResponseDto(bus);
    }
}
