package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу  сервиса банка.
 * Добавляет и удаляет пользователя,
 * открывает счет, позволяет переводить
 * деньги с одного счета на другой.
 * @ author Oleg Dubikov
 * @ 1.0
 */
public class BankService {
    /**
     * Хранение данных пользователя в коллекции типа Map.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в банк-сервис.
     * @param user Принимает данные пользователя.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод  пользователя из сервиса.
     * @param passport Принимает паспортные данные пользователя
     * @return Возвращает true , если пользователь удален
     * и false , если пользователь  не найден.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     *Метод добавляет новый счет пользователю,
     * если пользователь не null и у него нет счета.
     * @param passport Принимает паспортные данные пользователя.
     * @param account Принимает данные и проверяет, есть ли у пользователя счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
                users.get(user).add(account);
        }
    }

    /**
     *Метод находит пользователя по данным паспорта.
     * @param passport Принимает данные паспорта.
     * @return Возвращает результат поиска.
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     *Метод выполняет поиск счета , по паспорту и реквизитам пользователя.
     * @param passport Принимает данные паспорта пользователя и проверяет,
     * есть ли такой пользователь в сервисе.
     * @param requisite Принимает реквизиты счета и проверяет,
     * есть ли такой счет у пользователя.
     * @return Возвращает результат поиска счета.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     *Метод позволяет переводить деньги с одного счета на другой.
     * @param srcPassport Принимает паспортные данные пользователя, который переводит деньги.
     * @param srcRequisite Принимает реквизиты счета с которого переводятся деньги.
     * @param destPassport Принимает паспортные данные пользователя, который принимает деньги.
     * @param destRequisite Принимает рекизиты счета на который поступают деньги.
     * @param amount Принимает данные переводимой суммы.
     * @return Возвращает результат перевода.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     *Метод позволяет посмотреть список счетов пользователя.
     * @param user Принимает данные пользователя.
     * @return Возвращает данные о счете пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}