package com.triaspect.backend.controllers;

import com.triaspect.backend.dto.UbicacionDto;

import com.triaspect.backend.services.UbicacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("ubicacion")
public class UbicacionController {

    private UbicacionService ubicacionService;

    @PostMapping
    public ResponseEntity<UbicacionDto> createUbicacion(@RequestBody UbicacionDto ubicacionDto) {
       UbicacionDto savedUbicacion =  ubicacionService.createUbicacion(ubicacionDto);
       return new ResponseEntity<>(savedUbicacion, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UbicacionDto> getUbicacionById(@PathVariable("id") Long id) {
        UbicacionDto foundedUbicacion = ubicacionService.getUbicacionById(id);
        return ResponseEntity.ok(foundedUbicacion);
    }

    @GetMapping
    public ResponseEntity<List<UbicacionDto>> getAllUbicaciones() {
        List<UbicacionDto> ubicaciones = ubicacionService.getUbicaciones();
        return ResponseEntity.ok(ubicaciones);
    }

    @PutMapping ("{id}")
    public ResponseEntity<UbicacionDto> updateUbicacion( @PathVariable("id") Long id ,@RequestBody UbicacionDto ubicacionDto) {
        UbicacionDto ubicacion = ubicacionService.updateUbicacion(id, ubicacionDto);
        return ResponseEntity.ok(ubicacion);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUbicacion(@PathVariable("id") Long id) {
        ubicacionService.deleteUbicacion(id);
        return ResponseEntity.ok("Ubicacion eliminada con exito");
    }
}
