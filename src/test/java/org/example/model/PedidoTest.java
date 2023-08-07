package org.example.model;

import lombok.extern.log4j.Log4j2;
import org.example.model.enuns.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoTest extends GenericManagerTest {

    @Test
    public void testMapeamentoObjetoEmbutido() {
        Cliente cliente = manager.find(Cliente.class,3L);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setTotal(new BigDecimal(2000));
        pedido.setStatus(Status.PAGO);
        pedido.setDataConclusao(LocalDate.now());
        pedido.setNfId(123);

        pedido.setCliente(cliente);

        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        enderecoEntrega.setCep("123456");
        enderecoEntrega.setComplemento("Em frente a escola");
        enderecoEntrega.setNumero("99");
        enderecoEntrega.setLagraddouro("Rua do Paz");

        pedido.setEnderecoEntrega(enderecoEntrega);

        manager.getTransaction().begin();
        manager.persist(pedido);
        manager.getTransaction().commit();


        manager.clear();

        Pedido pedidoVerificado = manager.find(Pedido.class, 1L);
        Assert.assertNotNull(pedidoVerificado);
        Assert.assertNotNull(pedidoVerificado.getCliente());

        System.out.println(pedidoVerificado.getCliente().getNome());
    }
}