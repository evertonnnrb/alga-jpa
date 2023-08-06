package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.enuns.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDate dataPedido;
    private LocalDate dataConclusao;
    private Integer nfId;
    private Status status;
    private BigDecimal total;

}
