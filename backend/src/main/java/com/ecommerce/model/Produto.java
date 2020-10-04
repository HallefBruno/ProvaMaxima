
package com.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author hallef
 */
@Entity
@Data
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;
    
    @NotBlank(message = "Campo obrigatório!")
    @NotNull(message = "Campo obrigatório!")
    @NotEmpty(message = "Campo obrigatório!")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "Campo obrigatório!")
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    
    @Column(name = "imagem_url")
    private String imagemUrl;

    
}
