package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NotifyAccountTest {

    @Test
    public void whenTwoAccountsAddSent() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(notifyAccount.sent(accounts)).containsAll(expect);
    }

    @Test
    public void whenTwoAccountsEqualsOneRemove() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f")
                )
        );
        assertThat(notifyAccount.sent(accounts)).containsAll(expect);
    }
}