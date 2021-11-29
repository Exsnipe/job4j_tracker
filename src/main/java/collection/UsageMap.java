package collection;

import java.util.Map;
import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("tda@gmaol.com", "Tokarev Dima");
        hashMap.put("frd@yandex.ru", "Fedorov Roma");
        hashMap.put("kvs@rambler.ru", "Kirillov Viktor");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
    }
}
