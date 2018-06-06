package com.acmebank.test;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.acmebank.domain.Account;
import com.acmebank.service.AccountService;
import com.caucho.junit.ResinBeanConfiguration;
import com.caucho.junit.ResinBeanContainerRunner;

@RunWith(ResinBeanContainerRunner.class)
@ResinBeanConfiguration(beansXml = { "classpath:beans-test.xml" })
public class AccountServiceTest {

	@Inject
	private AccountService accountService;

	@Test
	public void testAddAccount() {
		Account account = new Account();
		account.setNumber("1111");
		account.setCustomer("nrahman");
		account.setBalance(1000.00);

		accountService.addAccount(account);
	}

	@Test
	public void testGetAccount() {
		Account account = accountService.getAccount("nrahman");
		assertNotNull(account);
	}

	@Test
	public void testUpdateAccount() {
		Account account = accountService.getAccount("nrahman");
		account.setBalance(1001.50);
		accountService.updateAccount(account);
	}

	@Test
	public void testDeleteAccount() {
		Account account = accountService.getAccount("nrahman");
		accountService.deleteAccount(account);
	}
}
