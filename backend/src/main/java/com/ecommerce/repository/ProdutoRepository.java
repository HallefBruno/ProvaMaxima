
package com.ecommerce.repository;

import com.ecommerce.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hallef
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(concat('%',?1,'%'))")
    public List<Produto> findByNomeContainingIgnoreCase(@Param("nome") String nome);
    
}
