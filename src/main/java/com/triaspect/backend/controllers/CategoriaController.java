package com.triaspect.backend.controllers;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.dto.ProveedorDto;
import com.triaspect.backend.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto) {
        CategoriaDto savedCategoria =  categoriaService.createCategoria(categoriaDto);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable("id") Long id) {
        CategoriaDto foundedCategoria = categoriaService.getCategoriaById(id);
        return ResponseEntity.ok(foundedCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        List<CategoriaDto> categorias = categoriaService.getCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PutMapping ("{id}")
    public ResponseEntity<CategoriaDto> updateCategoria( @PathVariable("id") Long id ,@RequestBody CategoriaDto categoriaDto) {
        CategoriaDto categoria = categoriaService.updateCategoria(id, categoriaDto);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok("Categoria eliminada con exito");
    }
}
