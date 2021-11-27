package search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dima", "Tokarev", "133479345", "Borisoglebsk"));
        ArrayList<Person> result = phoneDictionary.find("im");
        assertThat(result.get(0).getSurname(), is("Tokarev"));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dima", "Tokarev", "133479345", "Borisoglebsk"));
        ArrayList<Person> result = phoneDictionary.find("kare");
        assertThat(result.get(0).getName(), is("Dima"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dima", "Tokarev", "133479345", "Borisoglebsk"));
        ArrayList<Person> result = phoneDictionary.find("347");
        assertThat(result.get(0).getAddress(), is("Borisoglebsk"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dima", "Tokarev", "133479345", "Borisoglebsk"));
        ArrayList<Person> result = phoneDictionary.find("risogl");
        assertThat(result.get(0).getPhone(), is("133479345"));
    }

    @Test
    public void whenFindNothing() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Dima", "Tokarev", "133479345", "Borisoglebsk"));
        ArrayList<Person> result = phoneDictionary.find("protect");
        assertTrue(result.isEmpty());
    }
}