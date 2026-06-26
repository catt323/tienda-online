package com.tiendaonline.service;

import com.tiendaonline.dto.ProductoRequestDTO;
import com.tiendaonline.dto.ProductoResponseDTO;
import com.tiendaonline.mapper.ProductoMapper;
import com.tiendaonline.model.Producto;
import com.tiendaonline.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        Producto producto = productoMapper.convertirAEntidad(dto);
        Producto productoGuardado = productoRepository.save(producto);
        return productoMapper.convertirAResponseDTO(productoGuardado);
    }

    public List<ProductoResponseDTO> listar() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoResponseDTO> respuesta = new ArrayList<>();

        for (Producto producto : productos) {
            respuesta.add(productoMapper.convertirAResponseDTO(producto));
        }

        return respuesta;
    }

    public ProductoResponseDTO buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);

        if (producto == null) {
            return null;
        }

        return productoMapper.convertirAResponseDTO(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
