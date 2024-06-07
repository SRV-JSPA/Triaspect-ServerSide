package com.triaspect.backend.dto;

import com.triaspect.backend.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDto {
    private Long id;
    private String nombre;
    private List<Producto> productos;
}
