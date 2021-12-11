package search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> keyEqName = p -> p.getName().equals(key);
        Predicate<Person> keyEqSurname = p -> p.getSurname().equals(key);
        Predicate<Person> keyEqPhone = p -> p.getPhone().equals(key);
        Predicate<Person> keyEqAdress = p -> p.getAddress().equals(key);
        Predicate<Person> combine = keyEqAdress.or(keyEqPhone.or(keyEqName.or(keyEqSurname)));
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
