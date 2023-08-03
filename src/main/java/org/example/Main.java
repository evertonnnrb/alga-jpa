package org.example;

import org.example.model.Produto;
import org.example.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("alga-jpa");
        EntityManager manager = emf.createEntityManager();
        Produto produto = manager.find(Produto.class,1L);
        System.out.println(produto);
        manager.close();
        emf.close();

    }
}