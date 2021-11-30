package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class OrderConvert {
    public Map<String, Order> process(List<Order> list) {
        Map<String, Order> map = new HashMap<>();
        for (Order order : list) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}
