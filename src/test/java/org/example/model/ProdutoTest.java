package org.example.model;

import org.junit.*;

import java.math.BigDecimal;

public class ProdutoTest extends GenericManagerTest{

    @Test
    public void testShouldFind() {
        Produto produto = manager.find(Produto.class, 1L);
        System.out.println(produto);
        Assert.assertNotNull(produto);
        Assert.assertEquals(produto.getNome(), "Caixa JBL");
    }

    @Test
    public void testDevePersistirProduto(){

        Produto produtoPersist = new Produto();
        produtoPersist.setNome("Teclado");
        produtoPersist.setDescricao("Multilaser");
        produtoPersist.setValor(new BigDecimal(100));
        manager.getTransaction().begin();
        manager.persist(produtoPersist);
        manager.getTransaction().commit();
        manager.clear();

        testDevePersistirOutroProduto();
    }
    @Test
    public void testDevePersistirOutroProduto(){

        Produto produtoPersist = new Produto();
        produtoPersist.setNome("Pen Drive");
        produtoPersist.setDescricao("O melhor do mercado");
        produtoPersist.setValor(new BigDecimal(99));

        manager.getTransaction().begin();
        manager.persist(produtoPersist);
        manager.getTransaction().commit();

        Produto produto1 = manager.find(Produto.class,3L);
        Assert.assertTrue(produtoPersist.equals(produto1));
    }
    @Test
    public void testAtualizarReferencia() {
        Produto produto = manager.find(Produto.class, 1L);
        produto.setNome("Taco de baisiball");

        manager.refresh(produto);


    }
    @Test
    public void testDeveRemoverProduto(){
        testDevePersistirProduto();

        Produto produtoRemovido = manager.find(Produto.class, 1L);

        manager.getTransaction().begin();
        manager.remove(produtoRemovido);
        manager.getTransaction().commit();

        Assert.assertNull(manager.find(Produto.class,1L));
    }


    @Test
    public void testDeveAtualizarProduto(){
        Produto produto = new Produto();
        produto.setNome("Monitor 50''");
        produto.setDescricao("Monitor gigante samsung");
        produto.setValor(new BigDecimal(2500));

        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();

        Produto produtoAtulizacao = manager.find(Produto.class, 2L);
        produtoAtulizacao.setValor(new BigDecimal(3500));

        manager.getTransaction().begin();
        manager.merge(produtoAtulizacao);
        manager.getTransaction().commit();

    }

    @Test
    public void testAtualizacaoObjetoGerenciado(){
        Produto produto = manager.find(Produto.class,1L);
        produto.setNome("CAIXA DE SOM EM FALTA NO ESTOQUE");
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();

        Produto produtoVerificado = manager.find(Produto.class, 1L);

        Assert.assertEquals(produto.getNome(),produtoVerificado.getNome());
    }
}