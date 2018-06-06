package com.acmebank.service;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.acmebank.common.Audited;
import com.acmebank.dao.UserDao;
import com.acmebank.domain.User;

@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DefaultUserService implements UserService {

	@Inject
	private UserDao userDao;

	@Audited
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
}
