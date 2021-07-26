package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenNotSingleOrder() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("3sfe", "Dress");
        orders.add(order1);
        orders.add(new Order("3sfe", "NotDress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertTrue(map.size() == 1);
    }
}