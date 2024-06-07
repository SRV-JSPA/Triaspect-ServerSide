package com.triaspect.backend.controllers;

import com.triaspect.backend.dto.ProveedorDto;
import com.triaspect.backend.services.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("proveedor")
public class ProveedorController {

    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ProveedorDto> createProveedor(@RequestBody ProveedorDto proveedorDto) {
        ProveedorDto savedProveedor =  proveedorService.createProveedor(proveedorDto);
        return new ResponseEntity<>(savedProveedor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProveedorDto> getProveedorById(@PathVariable("id") Long id) {
        ProveedorDto foundedProveedor = proveedorService.getProveedorById(id);
        return ResponseEntity.ok(foundedProveedor);
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> getAllProveedores() {
        List<ProveedorDto> proveedores = proveedorService.getProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @PutMapping ("{id}")
    public ResponseEntity<ProveedorDto> updateProveedor( @PathVariable("id") Long id ,@RequestBody ProveedorDto proveedorDto) {
        ProveedorDto proveedor = proveedorService.updateProveedor(id, proveedorDto);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProveedor(@PathVariable("id") Long id) {
        proveedorService.deleteProveedor(id);
        return ResponseEntity.ok("Proveedor eliminado con exito");
    }

}
