package org.example.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericManagerTest {
    protected static EntityManagerFactory factory;
    protected static EntityManager manager;

    @BeforeClass
    public static void setUpBeforeClass() {
        factory = Persistence.createEntityManagerFactory("alga");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        factory.close();
    }

    @Before
    public void setUp() {
        manager = factory.createEntityManager();
    }

    @After
    public void after() {
        manager.close();
    }

}