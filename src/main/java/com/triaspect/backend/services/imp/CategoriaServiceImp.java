package com.triaspect.backend.services.imp;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.entity.Categoria;
import com.triaspect.backend.entity.Proveedor;
import com.triaspect.backend.exception.ResourceNotFoundException;
import com.triaspect.backend.mapper.CategoriaMapper;
import com.triaspect.backend.mapper.ProveedorMapper;
import com.triaspect.backend.repository.CategoriaRepository;
import com.triaspect.backend.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaServiceImp implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDto createCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = CategoriaMapper.mapCategoria(categoriaDto);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return CategoriaMapper.mapDto(savedCategoria);
    }

    @Override
    public CategoriaDto getCategoriaById(Long CategoriaId) {
        Categoria categoria = categoriaRepository.findById(CategoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));
        return CategoriaMapper.mapDto(categoria);
    }

    @Override
    public List<CategoriaDto> getCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map((categoria) -> CategoriaMapper.mapDto(categoria))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto updateCategoria(Long id, CategoriaDto categoriaDto) {
        Categoria foundCategoria = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"));

        foundCategoria.setNombre(categoriaDto.getNombre());
        foundCategoria.setDescripcion(categoriaDto.getDescripcion());
        Categoria updatedCategoria = categoriaRepository.save(foundCategoria);
        return CategoriaMapper.mapDto(updatedCategoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria foundCategoria = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoria no encontrada")
        );

        categoriaRepository.deleteById(id);
    }




}
