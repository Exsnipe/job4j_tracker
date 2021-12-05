package bank;

import java.util.Objects;

/**
 * Класс представляет собой модель данных Account, описывающую счет в банке
 * @author Dmitry Tokarev
 * @version 1.0
 */
public class Account {
    /**
     * Уникальный номер счета хранится в переменной requisite
     */
    private String requisite;
    /**
     * Данные о количестве денежных средств, находящихся на данном счете
     */
    private Double balance;

    /**
     * Конструктор класса Account
     * @param requisite реквизиты создаваемого счета
     * @param balance количество денежных средств, на создаваемом счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод предоставляет доступ к значению реквизитов счета
     * @return возвращает переменную requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает значение реквизитов счета
     * @param requisite реквизиты текущего счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод предоставляет доступ к значению денежных средств, находящихся на счету
     * @return возвращает переменную balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает значение баланса счета
     * @param balance баланс текущего счета
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * Сравнение объектов типа Account происходит по значению поля requisite
     * @param o сравниваемый объект
     * @return возвращает true при равенстве объектов и false при неравенстве
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return requisite.equals(account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
