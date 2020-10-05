
package com.ecommerce.repository;

import com.ecommerce.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author halle
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(concat('%',?1,'%'))")
    public List<Cliente> findByNomeContainingIgnoreCase(@Param("nome") String nome);

}
