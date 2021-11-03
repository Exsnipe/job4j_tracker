package pojo;

public class Shop {
   public static int getNullIndex(Product[] products) {
       for (int index = 0; index < products.length; index++) {
           if (products[index] == null) {
               return index;
           }
       }
       return -1;
   }

    public static void main(String[] args) {
        Product[] masProduct = new Product[5];
        masProduct[0] = new Product("Milk", 10);
        masProduct[1] = new Product("Bread", 4);
        masProduct[2] = new Product("Egg", 19);
        for (Product element : masProduct) {
            if (element != null) {
                System.out.println(element.getName());
            }
        }
    }
}

