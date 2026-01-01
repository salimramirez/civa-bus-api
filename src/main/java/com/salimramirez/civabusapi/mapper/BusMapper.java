package com.salimramirez.civabusapi.mapper;

import com.salimramirez.civabusapi.dto.BusRequestDto;
import com.salimramirez.civabusapi.dto.BusResponseDto;
import com.salimramirez.civabusapi.entity.Bus;
import com.salimramirez.civabusapi.entity.BusBrand;

public class BusMapper {
    public static Bus toEntity(BusRequestDto dto, BusBrand brand) {
        if (dto == null) return null;
        Bus bus = new Bus();
        bus.setBusNumber(dto.busNumber());
        bus.setPlate(dto.plate());
        bus.setCharacteristics(dto.characteristics());
        bus.setBrand(brand);
        bus.setActive(dto.active());
        return bus;
    }

    public static BusResponseDto toResponseDto(Bus bus) {
        if (bus == null) return null;
        return new BusResponseDto(
                bus.getId(),
                bus.getBusNumber(),
                bus.getPlate(),
                bus.getCreatedAt(),
                bus.getCharacteristics(),
                bus.getBrand() != null ? bus.getBrand().getName() : "No Brand",
                bus.getActive()
        );
    }
}
