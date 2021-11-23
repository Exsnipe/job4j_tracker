package ex;

public class FindE1 {
    public static int indexOf(String[] array, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < array.length; index++) {
            if (array[index].equals(key)) {
                return index;
            }
        }
        throw new ElementNotFoundException("Element did not found");
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4", "5"};
        try {
            System.out.println(FindE1.indexOf(array, "2"));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            System.out.println(FindE1.indexOf(array, "6"));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
