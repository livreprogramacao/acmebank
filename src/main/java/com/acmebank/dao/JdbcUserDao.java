package com.acmebank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;

import com.acmebank.domain.User;

@Dao
@LegacyImplementation
public class JdbcUserDao implements UserDao {

	@Inject
	@AccountJdbcResource
	private Statement statement;

	@Override
	public void addUser(User user) {
		try {
			statement
					.executeUpdate("INSERT INTO users (id, username, first_name, last_name, password) VALUES ("
							+ user.getId()
							+ ", '"
							+ user.getUsername()
							+ "', '"
							+ user.getFirstName()
							+ "', '"
							+ user.getLastName()
							+ "', '"
							+ user.getPassword()
							+ "')");
		} catch (SQLException e) {
			throw new RuntimeException("Data access error.", e);
		}
	}

	@Override
	public User getUser(String username) {
		User user = null;

		try {
			ResultSet resultSet = statement
					.executeQuery("SELECT id, username, first_name, last_name, password FROM users WHERE username='"
							+ username + "'");

			if (resultSet.next()) {
				user = new User();

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Data access error.", e);
		}

		return user;
	}

	@Override
	public void deleteUser(User user) {
		try {
			statement.executeUpdate("DELETE FROM users WHERE id = "
					+ user.getId());
		} catch (SQLException e) {
			throw new RuntimeException("Data access error.", e);
		}
	}
}
