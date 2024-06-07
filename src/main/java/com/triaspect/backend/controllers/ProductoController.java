package com.triaspect.backend.controllers;

import com.triaspect.backend.dto.CategoriaDto;
import com.triaspect.backend.dto.ProductoDto;
import com.triaspect.backend.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductoController {
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto) {
        ProductoDto savedProducto =  productoService.createProducto(productoDto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable("id") Long id) {
        ProductoDto foundedProducto = productoService.getProductoById(id);
        return ResponseEntity.ok(foundedProducto);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<ProductoDto> productos = productoService.getProductos();
        return ResponseEntity.ok(productos);
    }

    @PutMapping ("{id}")
    public ResponseEntity<ProductoDto> updateProducto( @PathVariable("id") Long id ,@RequestBody ProductoDto productoDto) {
        ProductoDto producto = productoService.updateProducto(id, productoDto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok("Producto eliminado con exito");
    }
}
