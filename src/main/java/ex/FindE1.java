package ex;

public class FindE1 {
    public static int indexOf(String[] array, int key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < array.length; index++) {
            if (index == key) {
                return index;
            }
        }
        throw new ElementNotFoundException("Index did not found");
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4", "5"};
        try {
            System.out.println(FindE1.indexOf(array, 2));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            System.out.println(FindE1.indexOf(array, 5));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
