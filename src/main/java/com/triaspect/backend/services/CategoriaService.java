package com.triaspect.backend.services;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.dto.ProveedorDto;

import java.util.List;

public interface CategoriaService {

    CategoriaDto createCategoria(CategoriaDto categoriaDto);

    CategoriaDto getCategoriaById(Long CategoriaId);

    List<CategoriaDto> getCategorias();

    CategoriaDto updateCategoria(Long id, CategoriaDto categoriaDto);

    void deleteCategoria(Long id);
}
