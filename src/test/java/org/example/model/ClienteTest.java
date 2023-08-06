package org.example.model;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest extends GenericManagerTest {

    @Test
    public void testDeveCadatrarCliente() {
        Cliente jao = new Cliente();
        jao.setNome("Jão da silva");

        Cliente maria = new Cliente();
        maria.setNome("Maria mm");

        manager.getTransaction().begin();
        manager.persist(maria);
        manager.persist(jao);
        manager.getTransaction().commit();
    }

    @Test
    public void testAtualizarClientes() {
        testDeveCadatrarCliente();
        Cliente cliente = manager.find(Cliente.class, 1L);
        cliente.setNome("Maria Da Silva");
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
        Cliente cliVerificado = manager.find(Cliente.class, 1L);
        Assert.assertEquals(cliente.getNome(), cliVerificado.getNome());
    }

    @Test
    public void testDeveRemoverCliente() {
        testDeveCadatrarCliente();
        Cliente cliente = manager.find(Cliente.class, 2L);
        manager.getTransaction().begin();
        manager.remove(cliente);
        manager.getTransaction().commit();
        Assert.assertNull(manager.find(Cliente.class, 2L));
    }

    @Test
    public void testDeveConsultarCliente() {
        testDeveCadatrarCliente();
        Cliente cliente = manager.find(Cliente.class, 1L);
        Assert.assertNotNull(cliente);
    }
}
