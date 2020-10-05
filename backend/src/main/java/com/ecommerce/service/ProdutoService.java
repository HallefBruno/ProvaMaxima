
package com.ecommerce.service;

import com.ecommerce.model.Produto;
import com.ecommerce.repository.ProdutoRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hallef
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Transactional
    public Produto salvar(Produto produto) {
        UUID cod = UUID.randomUUID();
        produto.setCodigo(cod.toString());
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo;
    }
    
    public List<Produto> pesquisarProdutoPorNome(String nome) {
        if(nome!=null&&!nome.isEmpty()) {
            return produtoRepository.findByNomeContainingIgnoreCase(nome);
        }
        throw new RuntimeException("Nome é obrigatório!");
    } 
    
}
