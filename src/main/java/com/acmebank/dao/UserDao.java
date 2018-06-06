package com.acmebank.dao;

import com.acmebank.domain.User;

public interface UserDao {

	public void addUser(User user);

	public User getUser(String username);

	public void deleteUser(User user);
}
