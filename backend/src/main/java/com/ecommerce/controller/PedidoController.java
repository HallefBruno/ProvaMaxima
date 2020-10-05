package com.ecommerce.controller;

import com.ecommerce.model.Cliente;
import com.ecommerce.service.ClienteService;
import com.ecommerce.model.Pedido;
import com.ecommerce.model.Produto;
import com.ecommerce.service.PedidoService;
import com.ecommerce.service.ProdutoService;
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
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping("salvar")
    public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }
    
    @GetMapping("clientes/{nome}")
    public ResponseEntity<?> getClientes(@PathVariable(value = "nome") String nome) {
        List<Cliente> clientes = clienteService.pesquisarClientePorNome(nome);
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("produtos/{nome}")
    public ResponseEntity<?> getProdutos(@PathVariable(value = "nome") String nome) {
        List<Produto> produtos = produtoService.pesquisarProdutoPorNome(nome);
        return ResponseEntity.ok(produtos);
    }

}
