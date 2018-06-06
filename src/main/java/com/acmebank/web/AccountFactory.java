package com.acmebank.web;

import com.acmebank.domain.Account;
import com.acmebank.domain.User;
import com.acmebank.service.AccountService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

public class AccountFactory implements Serializable {
  private static final long serialVersionUID = 1L;

  @Inject
  @LoggedIn
  private User user;

  @Inject
  private AccountService accountService;

  @Named
  @Produces
  @SessionScoped
  @SelectedAccount
  public Account getCurrentAccount()
  {
    return accountService.getAccount(user.getUsername());
  }
}
