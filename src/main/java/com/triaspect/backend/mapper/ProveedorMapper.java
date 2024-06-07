package com.triaspect.backend.mapper;

import com.triaspect.backend.dto.ProveedorDto;
import com.triaspect.backend.entity.Proveedor;

public class ProveedorMapper {

    public static ProveedorDto mapDto(Proveedor proveedor) {
        return new ProveedorDto(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getProductos()
        );
    }

    public static Proveedor mapProveedor(ProveedorDto proveedorDto) {
        return new Proveedor(
                proveedorDto.getId(),
                proveedorDto.getNombre(),
                proveedorDto.getProductos()
        );
    }
}
