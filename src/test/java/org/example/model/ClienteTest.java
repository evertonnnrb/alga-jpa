package org.example.model;

import org.example.model.enuns.Sexo;
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

    @Test
    public void testInsertCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("José Mineiro");
        cliente.setSexo(Sexo.MASCULINO);
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.clear();
        Cliente clienteVerificado = manager.find(Cliente.class, 3L);
        Assert.assertNotNull(cliente);
    }

    @Test
    public void testAddListCliente() {
        Cliente cliente[] = new Cliente[5];

        cliente[0].setNome("Marcos da Qeinte");
        cliente[0].setSexo(Sexo.MASCULINO);

        cliente[1].setNome("Mariana Aguiar");
        cliente[1].setSexo(Sexo.FEMININO);

        cliente[2].setNome("Joana Daiana");
        cliente[2].setSexo(Sexo.FEMININO);


        cliente[3].setNome("Joao da Silva");
        cliente[3].setSexo(Sexo.MASCULINO);


        cliente[4].setNome("Jhon Brow");
        cliente[4].setSexo(Sexo.MASCULINO);

        manager.getTransaction().begin();
        for (int x = 0; x < cliente.length; x++) {
            cliente[x] = new Cliente();
            manager.persist(cliente[x]);
            manager.getTransaction().commit();
        }
    }
}
