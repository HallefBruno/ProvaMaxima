package com.ecommerce.service;

import com.ecommerce.model.Pedido;
import com.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hallef
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Transactional
    public Pedido salvar(Pedido pedido) {
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return pedidoSalvo;
    }
    
}
