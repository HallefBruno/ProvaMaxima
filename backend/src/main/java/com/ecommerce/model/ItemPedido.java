
package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
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
    @Min(value = 1,message = "Minimo 1")
    private Integer quantidadeProduto;
    
}
