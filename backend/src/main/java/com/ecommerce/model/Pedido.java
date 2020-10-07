
package com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author hallef
 */
@Entity
@Data
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @Column
//    @NotNull(message = "Campo obrigatório!")
//    private Integer quantidade;
    
    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(mappedBy="id.pedido")
    private Set<ItemPedido> itens;

}
