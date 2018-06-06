package com.acmebank.service;

import java.text.DecimalFormat;

import javax.ejb.Asynchronous;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.acmebank.common.Audited;
import com.acmebank.dao.AccountDao;
import com.acmebank.domain.Account;

@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DefaultAccountService implements AccountService {

	@Inject
	private AccountDao accountDao;

	@Inject
	@Named("money")
	private DecimalFormat money;

	@Audited
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public Account getAccount(String customer) {
		return accountDao.getAccount(customer);
	}

	@Audited
	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	@Audited
	@Override
	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);
	}

	@Asynchronous
	@Override
	public void transfer(String toBank, String toAccount, String fromBank,
			String fromAccount, double amount) {
		try {
			Thread.sleep(3000);
			System.out.println("Performing transfer to bank: " + toBank
					+ ", account: " + toAccount + " from bank: " + fromBank
					+ ", account: " + fromAccount + " amount: "
					+ money.format(amount));
		} catch (InterruptedException e) {
			throw new RuntimeException("Error performing transfer", e);
		}
	}
}
