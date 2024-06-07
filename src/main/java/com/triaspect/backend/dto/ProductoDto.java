package com.triaspect.backend.dto;


import com.triaspect.backend.entity.Categoria;
import com.triaspect.backend.entity.Proveedor;
import com.triaspect.backend.entity.Ubicacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

    private Long id;

    private String nombre;

    private String descripcion;

    private String marca;

    private Integer stock;

    private Double precio;

    private Categoria categoria;

    private Proveedor proveedor;

    private Ubicacion ubicacion;

    private Date fechaCreacion;

    private Date ultimaFechaModificacion;
}
