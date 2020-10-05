package com.ecommerce.controller;

import com.ecommerce.model.Cliente;
import com.ecommerce.service.ClienteService;
import com.ecommerce.model.Pedido;
import com.ecommerce.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hallef
 */
@RestController
@RequestMapping("pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("salvar")
    public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }

    @GetMapping("pessoas/nome/{nome}")
    public ResponseEntity<?> pesquisarClientePorNome(@PathVariable(name = "nome") String nome) {
        return ResponseEntity.ok(nome);
//        List<Cliente> clientes = clienteService.pesquisarClientePorNome(nome);
//        if(clientes.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(clientes);
    }
    
}
