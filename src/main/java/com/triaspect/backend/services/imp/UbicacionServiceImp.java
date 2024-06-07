package com.triaspect.backend.services.imp;

import com.triaspect.backend.dto.UbicacionDto;
import com.triaspect.backend.entity.Ubicacion;
import com.triaspect.backend.exception.ResourceNotFoundException;
import com.triaspect.backend.mapper.UbicacionMapper;
import com.triaspect.backend.repository.UbicacionRepository;
import com.triaspect.backend.services.UbicacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UbicacionServiceImp implements UbicacionService {

    private UbicacionRepository ubicacionRepository;

    @Override
    public UbicacionDto createUbicacion(UbicacionDto ubicacionDto) {

        Ubicacion ubicacion = UbicacionMapper.mapUbicacion(ubicacionDto);
        Ubicacion savedUbicacion = ubicacionRepository.save(ubicacion);
        return UbicacionMapper.mapDto(savedUbicacion);
    }

    @Override
    public UbicacionDto getUbicacionById(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ubicacion no encontrada"));
        return UbicacionMapper.mapDto(ubicacion);
    }

    @Override
    public List<UbicacionDto> getUbicaciones() {
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        return ubicaciones.stream().map((ubicacion) -> UbicacionMapper.mapDto(ubicacion))
                .collect(Collectors.toList());
    }

    @Override
    public UbicacionDto updateUbicacion(Long id, UbicacionDto ubicacionDto) {
        Ubicacion foundUbicacion = ubicacionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ubicacion no encontrada"));

        foundUbicacion.setNombre(ubicacionDto.getNombre());
        Ubicacion updatedUbicacion = ubicacionRepository.save(foundUbicacion);
        return UbicacionMapper.mapDto(updatedUbicacion);
    }

    @Override
    public void deleteUbicacion(Long id) {
        Ubicacion foundUbicacion = ubicacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ubicacion no encontrada")
        );

        ubicacionRepository.deleteById(id);
    }


}
