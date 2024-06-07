package com.triaspect.backend.services.imp;

import com.triaspect.backend.dto.ProveedorDto;
import com.triaspect.backend.entity.Proveedor;
import com.triaspect.backend.entity.Ubicacion;
import com.triaspect.backend.exception.ResourceNotFoundException;
import com.triaspect.backend.mapper.ProveedorMapper;
import com.triaspect.backend.mapper.UbicacionMapper;
import com.triaspect.backend.repository.ProveedorRepository;
import com.triaspect.backend.services.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProveedorServiceImp implements ProveedorService {

    private ProveedorRepository proveedorRepository;

    @Override
    public ProveedorDto createProveedor(ProveedorDto proveedorDto) {
        Proveedor proveedor = ProveedorMapper.mapProveedor(proveedorDto);
        Proveedor savedProveedor = proveedorRepository.save(proveedor);
        return ProveedorMapper.mapDto(savedProveedor);
    }

    @Override
    public ProveedorDto getProveedorById(Long ProveedorId) {
        Proveedor proveedor = proveedorRepository.findById(ProveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));
        return ProveedorMapper.mapDto(proveedor);
    }

    @Override
    public List<ProveedorDto> getProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores.stream().map((proveedor) -> ProveedorMapper.mapDto(proveedor))
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDto updateProveedor(Long id, ProveedorDto proveedorDto) {
        Proveedor foundProveedor = proveedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));

        foundProveedor.setNombre(proveedorDto.getNombre());
        Proveedor updatedProveedor = proveedorRepository.save(foundProveedor);
        return ProveedorMapper.mapDto(updatedProveedor);
    }

    @Override
    public void deleteProveedor(Long id) {
        Proveedor foundProveedor = proveedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Proveedor no encontrado")
        );

        proveedorRepository.deleteById(id);
    }
}
