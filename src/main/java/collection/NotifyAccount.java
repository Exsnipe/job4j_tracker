package collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
            Set<Account> rsl = new HashSet<>();
            for (Account account : accounts) {
                rsl.add(account);
            }
            return rsl;
    }
}