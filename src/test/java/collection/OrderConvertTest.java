package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderConvertTest {

    @Test
    public void whenProcess() {
        List<Order> list = new ArrayList<>(Arrays.asList(
                new Order("1", "ball"),
                new Order("2", "table"),
                new Order("3", "phone")
        ));
        Map<String, Order> expected = new HashMap<>();
        expected.put("1", new Order("1", "ball"));
        expected.put("2", new Order("2", "table"));
        expected.put("3", new Order("3", "phone"));
        assertThat(new OrderConvert().process(list), is(expected));
    }

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = (HashMap<String, Order>) new OrderConvert().process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }
}