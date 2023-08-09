package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.enuns.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @OneToOne
    private NotaFiscal nfId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal total;

    @OneToMany
    private List<ItemPedido> pedidos = new ArrayList<>();

    @Embedded
    private EnderecoEntrega enderecoEntrega;

    @OneToOne(mappedBy = "pedido")
    private PagementoCartao pagementoCartao;
}
