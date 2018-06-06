package com.acmebank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.acmebank.domain.User;

@Dao
public class DefaultUserDao implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUser(String username) {
		Query query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.username = :username");
		query.setParameter("username", username);

		List<User> users = query.getResultList();

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));
	}
}
