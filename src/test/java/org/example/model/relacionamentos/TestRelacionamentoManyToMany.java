package org.example.model.relacionamentos;

import org.example.model.Categoria;
import org.example.model.GenericManagerTest;
import org.example.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestRelacionamentoManyToMany extends GenericManagerTest {

    @Test
    public void testMany(){
        Produto produto = manager.find(Produto.class,1L);
        Categoria categoria = manager.find(Categoria.class,1L);

        manager.getTransaction().begin();
        //categoria.setProdutos(Arrays.asList(produto));
        produto.setCategorias(Arrays.asList(categoria));
        manager.getTransaction().commit();
        manager.clear();

        Categoria categoriaVerificada = manager.find(Categoria.class,categoria.getId());
        Assert.assertFalse(categoriaVerificada.getProdutos().isEmpty());

    }

}
