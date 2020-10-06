
package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author halle
 */
@Entity
@Data
public class ItemPedido implements Serializable {
    
    @JsonIgnore
    @EmbeddedId
    private PedidoProduto id = new PedidoProduto();
    
    @Column(name = "quantidade_produto")
    private Integer quantidadeProduto;
    
}
