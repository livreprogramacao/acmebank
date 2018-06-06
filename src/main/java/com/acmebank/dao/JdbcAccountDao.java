package com.acmebank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;

import com.acmebank.domain.Account;

@Dao
@LegacyImplementation
public class JdbcAccountDao implements AccountDao {

  @Inject
  @AccountJdbcResource
  private Statement statement;

  @Override
  public void addAccount(Account account)
  {
    try {
      statement
          .executeUpdate("INSERT INTO accounts (id, number, balance, customer) VALUES ("
              + account.getId()
              + ", '"
              + account.getNumber()
              + "', "
              + account.getBalance() + ", '" + account.getCustomer() + "')");
    } catch (SQLException e) {
      throw new RuntimeException("Data access error.", e);
    }
  }

  @Override
  public Account getAccount(String customer)
  {
    Account account = null;

    try {
      ResultSet resultSet = statement
          .executeQuery("SELECT id, number, balance, customer FROM accounts WHERE customer='"
              + customer + "'");

      if (resultSet.next()) {
        account = new Account();

        account.setId(resultSet.getInt("id"));
        account.setNumber(resultSet.getString("number"));
        account.setBalance(resultSet.getDouble("balance"));
        account.setCustomer(resultSet.getString("customer"));
      }
    } catch (SQLException e) {
      throw new RuntimeException("Data access error.", e);
    }

    return account;
  }

  @Override
  public void updateAccount(Account account)
  {
    try {
      statement.executeUpdate("UPDATE accounts " + "SET number='"
          + account.getNumber() + "', balance=" + account.getBalance()
          + ", customer='" + account.getCustomer() + "' WHERE id="
          + account.getId());
    } catch (SQLException e) {
      throw new RuntimeException("Data access error.", e);
    }
  }

  @Override
  public void deleteAccount(Account account)
  {
    try {
      statement.executeUpdate("DELETE FROM accounts WHERE id="
          + account.getId());
    } catch (SQLException e) {
      throw new RuntimeException("Data access error.", e);
    }
  }
}
