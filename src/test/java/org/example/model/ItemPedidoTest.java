package org.example.model;

import junit.framework.TestCase;
import org.example.model.enuns.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemPedidoTest extends GenericManagerTest {

    @Test
    public void testInsertItemPedido(){
        Cliente cliente = manager.find(Cliente.class,3L);

        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        enderecoEntrega.setCep("123456");
        enderecoEntrega.setComplemento("Em frente a escola");
        enderecoEntrega.setNumero("99");
        enderecoEntrega.setLagraddouro("Rua do Paz");

        Produto produto = new Produto();
        produto.setNome("Sabão em pó");
        produto.setDescricao("Primeira linha de sabao");
        produto.setValor(new BigDecimal(20));

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setTotal(new BigDecimal(2000));
        pedido.setStatus(Status.PAGO);
        pedido.setDataConclusao(LocalDate.now());
        //pedido.setNfId(123);
        pedido.setCliente(cliente);
        pedido.setEnderecoEntrega(enderecoEntrega);


        manager.getTransaction().begin();
        manager.persist(pedido);
        manager.persist(produto);
        manager.getTransaction().commit();
        manager.clear();

        Pedido pedidoVerificado = manager.find(Pedido.class, 1L);
        Assert.assertNotNull(pedidoVerificado);
        Assert.assertNotNull(pedidoVerificado.getCliente());

        Produto produtoVerificado = manager.find(Produto.class,1L);
        Assert.assertNotNull(produtoVerificado);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(10);
        itemPedido.setPrecoProduto(new BigDecimal(200));
        itemPedido.setPedido(pedidoVerificado);
        itemPedido.setProduto(produtoVerificado);

        manager.getTransaction().begin();
        manager.persist(itemPedido);
        manager.getTransaction().commit();

    }
}