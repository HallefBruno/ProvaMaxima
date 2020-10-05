
package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author halle
 */
@Entity
public class ItemPedido implements Serializable {
    
    @JsonIgnore
    @EmbeddedId
    private PedidoProduto id = new PedidoProduto();
    
}
