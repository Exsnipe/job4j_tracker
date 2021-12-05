package bank;

import java.util.Objects;

    /**
    * Модель данных User, содержащая информацию о пользователе банка
    * @author Dmitry Tokarev
    * @version 1.0
    */
public class User {
    /**
    * Переменная passport, хранящая ланные о паспорте пользователя
    */
    private String passport;
    /**
    * Переменная name, хранящаяданные об имени пользователя
    */
    private String name;

    /**
     * Конструктор класс User
     * @param passport сохранение данных о паспорте нового пользователя
     * @param name сохранение данных об имени нового пользователя
     */
    public User(String passport, String name) {
        this.passport = passport;
        this.name = name;
    }

    /**
    * Метод предоставляет доступ к данным о паспорте пользователя
    * @return возвращает переменную passport
    */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает данные о паспорте пользователя
     * @param passport значение пасспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
    * Метод предоставляет доступ к данным об имени пользователя
    * @return возвращает переменную name
    */
    public String getName() {
        return name;
    }

    /**
    * Метод устанавливает данные об имени пользователя
    * @param name значение имени
    */
        public void setName(String name) {
        this.name = name;
    }

    /**
    * Сравнение объектов типа User происходит по значению поля passport
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
        User user = (User) o;
        return passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}