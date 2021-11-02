package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUi {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime  created = item.getCreated();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String dateTimeFormated = created.format(formater);
        System.out.println(dateTimeFormated);
    }
}
