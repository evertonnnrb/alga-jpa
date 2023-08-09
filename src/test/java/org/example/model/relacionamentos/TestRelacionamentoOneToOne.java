package org.example.model.relacionamentos;

import org.example.model.*;
import org.example.model.enuns.Sexo;
import org.example.model.enuns.Status;
import org.example.model.enuns.StatusPagamento;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class TestRelacionamentoOneToOne extends GenericManagerTest {

    @Test
    public void testOne() {

        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        cliente.setNome("Ary Santana");
        cliente.setSexo(Sexo.MASCULINO);
        pedido.setCliente(manager.find(Cliente.class, 1L));
        pedido.setStatus(Status.AGUARDANDO);
        pedido.setDataPedido(LocalDate.now());
        pedido.setDataConclusao(LocalDate.of(2023, 8, 22));
        pedido.setTotal(new BigDecimal(20000));
        EnderecoEntrega entrega = new EnderecoEntrega();
        entrega.setLagraddouro("Rua do poeta");
        entrega.setNumero("900");
        entrega.setCep("0000000");
        entrega.setComplemento("Nenhum");

        pedido.setEnderecoEntrega(entrega);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setXml("cdmcdclkmd");
        notaFiscal.setDataEmissao(new Date());

        pedido.setNfId(notaFiscal);

        PagementoCartao pagementoCartao = new PagementoCartao();
        pagementoCartao.setPedido(manager.find(Pedido.class, 1L));
        pagementoCartao.setNumero("234");
        pagementoCartao.setStatusPagamento(StatusPagamento.RECEBIDO);

        pedido.setPagementoCartao(manager.find(PagementoCartao.class, 1L));
        notaFiscal.setPedido(pedido);

        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.persist(notaFiscal);
        manager.persist(pedido);
        manager.persist(pagementoCartao);
        manager.getTransaction().commit();
        manager.clear();

        Pedido pedidoVerificado = manager.find(Pedido.class, 1L);
        Assert.assertNotNull(pedidoVerificado);
    }

}
