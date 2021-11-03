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
        for (Book element : masBook) {
            System.out.println("Book: " + element.getName() + " Has "
                    + element.getPageAmount() + " pages");
        }
        Book buf = masBook[0];
        masBook[0] = masBook[3];
        masBook[3] = buf;
        System.out.println("");
        for (Book element : masBook) {
            System.out.println("Book: " + element.getName() + " Has "
                    + element.getPageAmount() + " pages");
        }
        for (Book element : masBook) {
            if ("Clean code".equals(element.getName())) {
                System.out.println(element.getName() + " " + element.getPageAmount());
            }
        }
    }
}
