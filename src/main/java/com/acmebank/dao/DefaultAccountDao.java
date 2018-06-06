package com.acmebank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.acmebank.domain.Account;

@Dao
public class DefaultAccountDao implements AccountDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addAccount(Account account) {
		entityManager.persist(account);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Account getAccount(String customer) {
		Query query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.customer = :customer");
		query.setParameter("customer", customer);

		List<Account> accounts = query.getResultList();

		if (!accounts.isEmpty()) {
			return accounts.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateAccount(Account account) {
		entityManager.merge(account);
	}

	@Override
	public void deleteAccount(Account account) {
		entityManager.remove(entityManager.merge(account));
	}
}
