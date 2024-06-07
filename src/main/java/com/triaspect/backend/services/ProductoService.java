package com.triaspect.backend.services;


import com.triaspect.backend.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto createProducto(ProductoDto productoDto);

    ProductoDto getProductoById(Long ProductoId);

    List<ProductoDto> getProductos();

    ProductoDto updateProducto(Long id, ProductoDto productoDto);

    void deleteProducto(Long id);
}
