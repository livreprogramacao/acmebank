package com.acmebank.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import com.caucho.inject.TransactionScoped;

public class AccountJdbcResourceFactory {

	@Resource(name = "jdbc/AcmeBankDB")
	private DataSource dataSource;

	@Produces
	@AccountJdbcResource
	@TransactionScoped
	public Connection createAccountConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void closeAccountConnection(
			@Disposes @AccountJdbcResource Connection connection)
			throws SQLException {
		connection.close();
	}

	@Produces
	@AccountJdbcResource
	@TransactionScoped
	public Statement createAccountStatement(
			@AccountJdbcResource Connection connection) throws SQLException {
		return connection.createStatement();
	}

	public void closeAccountStatement(
			@Disposes @AccountJdbcResource Statement statement)
			throws SQLException {
		statement.close();
	}
}
