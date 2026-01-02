package com.salimramirez.civabusapi.controller;

import com.salimramirez.civabusapi.dto.BusResponseDto;
import com.salimramirez.civabusapi.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
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
@Tag(name = "Bus", description = "Endpoints para la gestión de buses")
public class BusController {

    private final BusService busService;

    public  BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    @Operation(summary = "Obtener lista paginada de buses",
            description = "Retorna una página de buses con su información detallada y marca")
    public ResponseEntity<Page<BusResponseDto>> getAllBuses(@ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(busService.findAllBuses(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener bus por ID",
            description = "Busca un bus específico en la base de datos por su identificador único")
    public ResponseEntity<BusResponseDto> getBusById(@PathVariable Long id) {
        return ResponseEntity.ok(busService.findBusById(id));
    }
}
