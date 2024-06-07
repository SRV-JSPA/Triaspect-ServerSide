package com.triaspect.backend.services;

import com.triaspect.backend.dto.UbicacionDto;

import java.util.List;


public interface UbicacionService {
    UbicacionDto createUbicacion(UbicacionDto ubicacionDto);

    UbicacionDto getUbicacionById(Long UbicacionId);

    List<UbicacionDto> getUbicaciones();

    UbicacionDto updateUbicacion(Long id, UbicacionDto ubicacionDto);

    void deleteUbicacion(Long id);
}
