
package com.ecommerce.service;

import com.ecommerce.model.Cliente;
import com.ecommerce.repository.ClienteRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author halle
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Transactional
    public Cliente salvar(Cliente cliente) {
        UUID cod = UUID.randomUUID();
        cliente.setCodigo(cod.toString());
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }
    
}
