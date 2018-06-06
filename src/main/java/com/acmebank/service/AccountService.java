package com.acmebank.service;

import com.acmebank.domain.Account;

public interface AccountService {

    public void addAccount(Account account);

    public Account getAccount(String customer);

    public void deleteAccount(Account account);

    public void updateAccount(Account account);

    public void transfer(String toBank, String toAccount, String fromBank,
            String fromAccount, double amount);
}
