package bank;

import java.util.*;

/**
 * Класс BankService реализует систему управления данными о пользователях банка и их счетах
 * @author Dmitry Tokarev
 */
public class BankService {
    /**
     * Хранение данных о пользователях и их счетах организовано в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя при условии, что данного пользователя в коллекции еще нет
     * @param user пользователь, которого необходимо добавить
     */
    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет пользователю, данные о паспорте которого переданы в параметрах счет,
     * переданный в параметрах, при условии, что этого счета у пользователя еще нет
     * @param passport пасспорт пользователя
     * @param account счет в банке, который необходимо добавить пользователю
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по данным пасспорта
     * @param passport пасспорт пользователя
     * @return возвращает пользователя, если он найден или null, если подобного
     * пользователя в системе нет
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        rsl = users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
            return rsl;
    }

    /**
     * Метод ищет у пользователя, пасспорт которого передан в параметрах, счет
     * реквизиты которого переданы в параметрах.
     * @param passport значение пасспорта пользователя
     * @param requisite значение реквизитов счета
     * @return возвращает счет, если он найден или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            Account account = users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
            return Optional.of(account);
        }
        return null;
    }

    /**
     * Метод переводит денежные средства с одного счета на другой.
     * Информация о переводе передается в параметрах
     * @param srcPassport пользователь, со счета которого нужно списать средства
     * @param srcRequisite счет, с которого нужно списать средства
     * @param destPassport пользователь, на счет которого нужно зачислить средства
     * @param destRequisite счет, на который нужно зачислить средства
     * @param amount сумма перевода
     * @return возвращает true случае успеха перевода, false в обратном случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport,
                                 String destRequisite, double amount) {
        Account outCome = findByRequisite(srcPassport, srcRequisite).get();
        Account inCome = findByRequisite(destPassport, destRequisite).get();
        if (outCome != null && inCome != null && outCome.getBalance() >= amount) {
            outCome.setBalance(outCome.getBalance() - amount);
            inCome.setBalance(inCome.getBalance() + amount);
            return true;
        }
        return false;
    }
}
