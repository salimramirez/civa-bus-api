package com.salimramirez.civabusapi.controller;

import com.salimramirez.civabusapi.dto.BusResponseDto;
import com.salimramirez.civabusapi.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    private final BusService busService;

    public  BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<Page<BusResponseDto>> getAllBuses(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(busService.findAllBuses(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponseDto> getBusById(@PathVariable Long id) {
        return ResponseEntity.ok(busService.findBusById(id));
    }
}
