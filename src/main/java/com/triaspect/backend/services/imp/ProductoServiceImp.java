package com.triaspect.backend.services.imp;

import com.triaspect.backend.dto.ProductoDto;
import com.triaspect.backend.entity.Categoria;
import com.triaspect.backend.entity.Producto;
import com.triaspect.backend.exception.ResourceNotFoundException;
import com.triaspect.backend.mapper.CategoriaMapper;
import com.triaspect.backend.mapper.ProductoMapper;
import com.triaspect.backend.repository.ProductoRepository;
import com.triaspect.backend.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoServiceImp implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public ProductoDto createProducto(ProductoDto productoDto) {
        Producto producto = ProductoMapper.mapProducto(productoDto);
        Producto savedProducto = productoRepository.save(producto);
        return ProductoMapper.mapDto(savedProducto);
    }

    @Override
    public ProductoDto getProductoById(Long ProductoId) {
        Producto producto = productoRepository.findById(ProductoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        return ProductoMapper.mapDto(producto);
    }

    @Override
    public List<ProductoDto> getProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map((producto) -> ProductoMapper.mapDto(producto))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto updateProducto(Long id, ProductoDto productoDto) {
        Producto foundProducto = productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        foundProducto.setNombre(productoDto.getNombre());
        foundProducto.setDescripcion(productoDto.getDescripcion());
        foundProducto.setMarca(productoDto.getMarca());
        foundProducto.setStock(productoDto.getStock());
        foundProducto.setPrecio(productoDto.getPrecio());
        foundProducto.setCategoria(productoDto.getCategoria());
        foundProducto.setProveedor(productoDto.getProveedor());
        foundProducto.setUbicacion(productoDto.getUbicacion());
        foundProducto.setFechaCreacion(productoDto.getFechaCreacion());
        foundProducto.setUltimaFechaModificacion(productoDto.getUltimaFechaModificacion());
        Producto updatedProducto = productoRepository.save(foundProducto);
        return ProductoMapper.mapDto(updatedProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto foundProducto = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Producto no encontrado")
        );

        productoRepository.deleteById(id);
    }
}
