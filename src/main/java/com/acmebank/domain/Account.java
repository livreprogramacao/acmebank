package com.acmebank.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue
  private long id;
  private String number;
  private double balance;
  private String customer;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setBalance(double balance)
  {
    this.balance = balance;
  }

  public String getCustomer()
  {
    return customer;
  }

  public void setCustomer(String customer)
  {
    this.customer = customer;
  }

  @Override
  public String toString()
  {
    return "[Account[id=" + id + "][number=" + number + "][customer="
        + customer + "][balance=" + balance + "]]";
  }
}
