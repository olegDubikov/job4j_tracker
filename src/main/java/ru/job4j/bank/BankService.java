package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (user != null) {
            users.putIfAbsent(user, new ArrayList<>());
        }
    }

    public boolean deleteUser(String passport) {
        boolean b = false;
        if (findByPassport(passport) != null) {
            users.remove(findByPassport(passport));
            b = true;
        }
        return b;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!getAccounts(user).contains(account)) {
            getAccounts(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        if (findByRequisite(srcPassport, srcRequisite) == null
                || findByRequisite(destPassport, destRequisite) == null
                || findByRequisite(srcPassport, srcRequisite).getBalance() < amount) {
            return result;
        } else {
            findByRequisite(destPassport, destRequisite).
                    setBalance(findByRequisite(destPassport, destRequisite).
                            getBalance() + amount
                    );
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}