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
        Predicate<Person> keyEqName = p -> p.getName().contains(key);
        Predicate<Person> keyEqSurname = p -> p.getSurname().contains(key);
        Predicate<Person> keyEqPhone = p -> p.getPhone().contains(key);
        Predicate<Person> keyEqAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = keyEqAddress.or(keyEqPhone.or(keyEqName.or(keyEqSurname)));
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
