package com.triaspect.backend.mapper;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.entity.Categoria;

public class CategoriaMapper {
    public static CategoriaDto mapDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getProductos()
        );
    }

    public static Categoria mapCategoria(CategoriaDto categoriaDto) {
        return new Categoria(
                categoriaDto.getId(),
                categoriaDto.getNombre(),
                categoriaDto.getDescripcion(),
                categoriaDto.getProductos()
        );
    }
}
