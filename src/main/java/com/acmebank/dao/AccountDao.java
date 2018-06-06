package com.acmebank.dao;

import com.acmebank.domain.Account;

public interface AccountDao {

    public void addAccount(Account account);

    public Account getAccount(String customer);

    public void updateAccount(Account account);

    public void deleteAccount(Account account);
}
