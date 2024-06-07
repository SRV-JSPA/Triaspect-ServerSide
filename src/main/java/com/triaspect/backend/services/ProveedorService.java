package com.triaspect.backend.services;

import com.triaspect.backend.dto.ProveedorDto;


import java.util.List;

public interface ProveedorService {
    ProveedorDto createProveedor(ProveedorDto proveedorDto);

    ProveedorDto getProveedorById(Long ProveedorId);

    List<ProveedorDto> getProveedores();

    ProveedorDto updateProveedor(Long id, ProveedorDto proveedorDto);

    void deleteProveedor(Long id);
}
