package com.acmebank.web;

import com.acmebank.domain.Account;
import com.acmebank.service.AccountService;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class Transfer implements Serializable {
  private static final long serialVersionUID = 1L;

  @Inject
  private AccountService accountService;

  @Inject
  private Conversation conversation;

  private String fromBank;
  private String fromAccount;
  private String toBank;
  private String toAccount;
  private double amount;

  @Inject
  public void setAccount(@SelectedAccount Account account)
  {
    fromBank = "Acme Bank";
    fromAccount = account.getNumber();
    toBank = "Acme Bank";
  }

  public String getFromAccount()
  {
    return fromAccount;
  }

  public void setFromAccount(String fromAccount)
  {
    this.fromAccount = fromAccount;
  }

  public String getFromBank()
  {
    return fromBank;
  }

  public void setFromBank(String fromBank)
  {
    this.fromBank = fromBank;
  }

  public String getToAccount()
  {
    return toAccount;
  }

  public void setToAccount(String toAccount)
  {
    this.toAccount = toAccount;
  }

  public String getToBank()
  {
    return toBank;
  }

  public void setToBank(String toBank)
  {
    this.toBank = toBank;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }

  public String enterToBank()
  {
    conversation.begin();

    return "enter_to_bank.jsf";
  }

  public String transfer()
  {
    accountService.transfer(toBank, toAccount, fromBank, fromAccount, amount);

    conversation.end();

    return "account.jsf";
  }
}
