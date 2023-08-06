package org.example.model.enuns;

import org.junit.Assert;
import org.junit.Test;

public class SexoTest {

    @Test
    public void testSexoCliente() {
        Sexo sexoCliente = Sexo.getSexoCliente(0);
        System.out.println(sexoCliente);
        Assert.assertTrue(sexoCliente.equals("FEMININO"));
    }

}