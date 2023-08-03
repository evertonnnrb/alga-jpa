package org.example.model;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest extends GenericManagerTest {


    @Test
    public void testShouldFind() {
        Produto produto = manager.find(Produto.class, 1L);
        System.out.println(produto);
        Assert.assertNotNull(produto);
        Assert.assertEquals(produto.getNome(), "Caixa JBL");
    }

    @Test
    public void testAtualizarReferncai() {
        Produto produto = manager.find(Produto.class, 1L);
        produto.setNome("Taco de baisiball");
        manager.refresh(produto);

    }
}