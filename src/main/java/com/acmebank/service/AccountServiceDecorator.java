package com.acmebank.service;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import com.acmebank.domain.Account;

@Decorator
public class AccountServiceDecorator implements AccountService {

  private static final double LARGE_AMOUNT = 1000.00;
  @Inject
  @Delegate
  private AccountService accountService;

  @Override
  public void addAccount(Account account)
  {
    if (account.getBalance() > LARGE_AMOUNT) {
      System.out.println("Large amount alert on account: "
          + account.getNumber() + " amount: " + account.getBalance());
    }

    accountService.addAccount(account);
  }

  @Override
  public Account getAccount(String customer)
  {
    return accountService.getAccount(customer);
  }

  @Override
  public void updateAccount(Account account)
  {
    if (account.getBalance() > LARGE_AMOUNT) {
      System.out.println("Large amount alert on account: "
          + account.getNumber() + " amount: " + account.getBalance());
    }

    accountService.updateAccount(account);
  }

  @Override
  public void deleteAccount(Account account)
  {
    if (account.getBalance() > LARGE_AMOUNT) {
      System.out.println("Large amount alert on account: "
          + account.getNumber() + " amount: " + account.getBalance());
    }

    accountService.deleteAccount(account);
  }

  @Override
  public void transfer(String toBank, String toAccount, String fromBank,
      String fromAccount, double amount)
  {
    if (amount > LARGE_AMOUNT) {
      System.out.println("Large amount alert on account: " + fromAccount
          + " amount: " + amount);
    }

    accountService.transfer(toBank, toAccount, fromBank, fromAccount, amount);
  }
}
