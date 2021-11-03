package pojo;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenNullIs3() {
        Product[] products =  new Product[5];
        products[0] = new Product("Egg", 13);
        products[1] = new Product("Milk", 2);
        products[2] = new Product("Bread", 2);
        int rsl = Shop.getNullIndex(products);
        Assert.assertEquals(3, rsl);
    }

    @Test
    public void whenNullIs0() {
        Product[] products =  new Product[4];
        products[1] = new Product("Bread", 2);
        int rsl = Shop.getNullIndex(products);
        Assert.assertEquals(0, rsl);
    }

    @Test
    public void whenNoNull() {
        Product[] products = new Product[2];
        products[0] = new Product("Bread", 9);
        products[1] = new Product("Egg", 4);
        int rsl = Shop.getNullIndex(products);
        Assert.assertEquals(-1, rsl);
    }
}