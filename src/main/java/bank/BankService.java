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
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
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
            return users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> outCome = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> inCome = findByRequisite(destPassport, destRequisite);
        if (outCome.isPresent() && inCome.isPresent() && outCome.get().getBalance() >= amount) {
            outCome.get().setBalance(outCome.get().getBalance() - amount);
            inCome.get().setBalance(inCome.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
