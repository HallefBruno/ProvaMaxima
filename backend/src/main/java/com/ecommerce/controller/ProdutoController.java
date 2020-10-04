package com.ecommerce.controller;

import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hallef
 */
@RestController
@RequestMapping("produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping("salvar")
    public ResponseEntity<?> salvar(@Valid @RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.ok(produtoSalvo);
    }
    
}
