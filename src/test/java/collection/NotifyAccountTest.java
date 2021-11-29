package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("123", "Petr", "eDer3432f")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void sent1() {
        List<Account> accounts = new ArrayList<>(Arrays.asList(
                new Account("2010 353", "Dima", "500"),
                new Account("2014 597", "Zhanna", "100"),
                new Account("2010 353", "Dima", "500"),
                new Account("2010 353", "", ""),
                new Account("2007 345", "Eva", "65")
        ));
        Set<Account> expected = new HashSet<>(Arrays.asList(
                new Account("2010 353", "Dima", "500"),
                new Account("2014 597", "Zhanna", "100"),
                new Account("2007 345", "Eva", "65")
        ));
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}