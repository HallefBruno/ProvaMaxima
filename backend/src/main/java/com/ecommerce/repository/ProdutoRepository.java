
package com.ecommerce.repository;

import com.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hallef
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
