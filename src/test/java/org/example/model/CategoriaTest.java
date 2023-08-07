package org.example.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CategoriaTest extends GenericManagerTest {

    @Test
    public void testInsertCategoria(){

        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletronicos");

        Categoria categoriaFilha = new Categoria();
        categoriaFilha.setNome("Celulares");
        categoriaFilha.setCategoriaPaiId(categoriaPai);


        manager.getTransaction().begin();
        manager.persist(categoriaPai);
        manager.persist(categoriaFilha);
        manager.getTransaction().commit();
        manager.clear();

        Categoria categoriaVerificacaoPai = manager.find(Categoria.class,categoriaPai.getId());
        Assert.assertNotNull(categoriaVerificacaoPai);

        Categoria categoriaVerificacaoFilha = manager.find(Categoria.class,categoriaFilha.getId());
        Assert.assertNotNull(categoriaVerificacaoFilha);
    }

}