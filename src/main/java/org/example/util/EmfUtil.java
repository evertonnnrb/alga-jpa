package org.example.util;

import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfUtil {

    @Getter
    private static EntityManagerFactory emf = null;

    {
        emf = Persistence.createEntityManagerFactory("alga-jpa");
    }



}
