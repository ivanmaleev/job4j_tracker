package ru.job4j.integration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrdersStoreTest {
    private BasicDataSource pool = new BasicDataSource();

    @Before
    public void setUp() throws SQLException {
        pool.setDriverClassName("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true");
        pool.setUsername("sa");
        pool.setPassword("");
        pool.setMaxTotal(2);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./db/scripts/update_002.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @Test
    public void whenSaveOrderAndFindAllOneRowWithDescription() {
        OrdersStore store = new OrdersStore(pool);

        store.save(Order.of("name1", "description1"));

        List<Order> all = (List<Order>) store.findAll();

        assertThat(all.size(), is(1));
        assertThat(all.get(0).getDescription(), is("description1"));
        assertThat(all.get(0).getName(), is("name1"));
    }

    @Test
    public void whenSaveOrderAndFindById() {
        OrdersStore store = new OrdersStore(pool);

        Order save = store.save(Order.of("name2", "description2"));

        Order byId = store.findById(save.getId());

        assertThat(byId.getName(), is("name2"));
        assertThat(byId.getDescription(), is("description2"));
    }

    @Test
    public void whenSaveOrderAndUpdate() {
        OrdersStore store = new OrdersStore(pool);

        Order order = Order.of("name2", "description2");
        Order save = store.save(order);
        order.setName("name3");
        assertTrue( store.updateOrder(save.getId(), order));
    }

    @Test
    public void whenSaveOrderAndFindByName() {
        OrdersStore store = new OrdersStore(pool);

        store.save(Order.of("name4", "description4"));

        Order byName = store.findByName("name4");

        assertThat(byName.getName(), is("name4"));
        assertThat(byName.getDescription(), is("description4"));
    }

    @After
    public void refreshBD() {
        try (Connection con = pool.getConnection();
             PreparedStatement pr = con.prepareStatement(
                     "DELETE FROM orders; ")) {
            pr.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}