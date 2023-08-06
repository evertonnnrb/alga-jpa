package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.enuns.StatusPagamento;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pagamento_boleto")
public class PagementoBoleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Integer pedidoId;
    private StatusPagamento statusPagamento;
    private String codBarras;

}
