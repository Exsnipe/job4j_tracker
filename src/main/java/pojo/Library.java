package pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 567);
        Book headJava = new Book("Head first java", 768);
        Book harryPotter = new Book("Harry Potter", 732);
        Book anneFromGB = new Book("Anne with an E", 415);
        Book[] masBook = new Book[4];
        masBook[0] = cleanCode;
        masBook[1] = headJava;
        masBook[2] = harryPotter;
        masBook[3] = anneFromGB;
        for (int i = 0; i < masBook.length; i++) {
            System.out.println("Book: " + masBook[i].getName() + " Has "
                    + masBook[i].getPageAmount() + " pages");
        }
        Book buf = masBook[0];
        masBook[0] = masBook[3];
        masBook[3] = buf;
        System.out.println("");
        for (int i = 0; i < masBook.length; i++) {
            System.out.println("Book: " + masBook[i].getName() + " Has "
                    + masBook[i].getPageAmount() + " pages");
        }
        for (int i = 0; i < masBook.length; i++) {
            if (masBook[i].getName().equals("Clean code")) {
                System.out.println(masBook[i].getName() + " " + masBook[i].getPageAmount());
            }
        }
    }
}
