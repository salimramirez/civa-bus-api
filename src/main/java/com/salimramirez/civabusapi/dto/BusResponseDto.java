package com.salimramirez.civabusapi.dto;

import java.time.LocalDateTime;

public record BusResponseDto(
        Long id,
        String busNumber,
        String plate,
        LocalDateTime createdAt,
        String characteristics,
        BusBrandDto brand,
        Boolean active
) {
}
