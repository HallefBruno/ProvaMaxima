
package com.ecommerce.repository;

import com.ecommerce.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author halle
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    public List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
