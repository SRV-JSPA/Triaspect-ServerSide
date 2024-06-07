package com.triaspect.backend.mapper;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.dto.ProductoDto;
import com.triaspect.backend.entity.Categoria;
import com.triaspect.backend.entity.Producto;

public class ProductoMapper {
    public static ProductoDto mapDto(Producto producto) {
        return new ProductoDto(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getMarca(),
                producto.getStock(),
                producto.getPrecio(),
                producto.getCategoria(),
                producto.getProveedor(),
                producto.getUbicacion(),
                producto.getFechaCreacion(),
                producto.getUltimaFechaModificacion()
        );
    }

    public static Producto mapProducto(ProductoDto productoDto) {
        return new Producto(
                productoDto.getId(),
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getMarca(),
                productoDto.getStock(),
                productoDto.getPrecio(),
                productoDto.getCategoria(),
                productoDto.getProveedor(),
                productoDto.getUbicacion(),
                productoDto.getFechaCreacion(),
                productoDto.getUltimaFechaModificacion()
        );
    }
}
