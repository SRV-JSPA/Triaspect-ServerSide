package com.triaspect.backend.mapper;

import com.triaspect.backend.dto.UbicacionDto;
import com.triaspect.backend.entity.Ubicacion;

public class UbicacionMapper {

    public static UbicacionDto mapDto(Ubicacion ubicacion) {
        return new UbicacionDto(
                ubicacion.getId(),
                ubicacion.getNombre(),
                ubicacion.getProductos()
        );
    }

    public static Ubicacion mapUbicacion(UbicacionDto ubicacionDto) {
        return new Ubicacion(
                ubicacionDto.getId(),
                ubicacionDto.getNombre(),
                ubicacionDto.getProductos()
        );
    }
}
