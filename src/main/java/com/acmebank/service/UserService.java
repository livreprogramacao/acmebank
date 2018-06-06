package com.acmebank.service;

import com.acmebank.domain.User;

public interface UserService {

	public void addUser(User user);

	public User getUser(String username);

	public void deleteUser(User user);
}
