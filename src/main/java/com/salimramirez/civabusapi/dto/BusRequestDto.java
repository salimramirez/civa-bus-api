package com.salimramirez.civabusapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BusRequestDto(
        @NotBlank(message = "Bus number is required")
        String busNumber,

        @NotBlank(message = "Plate is required")
        String plate,

        String characteristics,

        @NotNull(message = "Brand ID is required")
        Long brandId,

        @NotNull(message = "Active status is required")
        Boolean active
) {
}
