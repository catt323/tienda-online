package com.tiendaonline.service;

import com.tiendaonline.dto.ClienteRequestDTO;
import com.tiendaonline.dto.ClienteResponseDTO;
import com.tiendaonline.mapper.ClienteMapper;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO crear(ClienteRequestDTO dto) {
        Cliente cliente = clienteMapper.convertirAEntidad(dto);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.convertirAResponseDTO(clienteGuardado);
    }

    public List<ClienteResponseDTO> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> respuesta = new ArrayList<>();

        for (Cliente cliente : clientes) {
            respuesta.add(clienteMapper.convertirAResponseDTO(cliente));
        }

        return respuesta;
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente == null) {
            return null;
        }

        return clienteMapper.convertirAResponseDTO(cliente);
    }
}
