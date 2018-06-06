package com.acmebank.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acmebank.domain.Account;
import com.acmebank.domain.User;
import com.acmebank.service.AccountService;
import com.acmebank.service.UserService;

@WebServlet(name = "DataPopulatorServlet", urlPatterns = { "/populate" })
public class DataPopulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;

	@Inject
	private AccountService accountService;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			out.println("Populating application data...");

			User user = userService.getUser("nrahman");

			if (user != null) {
				out.println("Resetting user 1...");

				Account account = accountService.getAccount(user.getUsername());

				accountService.deleteAccount(account);
				userService.deleteUser(user);
			}

			user = userService.getUser("rrahman");

			if (user != null) {
				out.println("Resetting user 2...");

				Account account = accountService.getAccount(user.getUsername());

				accountService.deleteAccount(account);
				userService.deleteUser(user);
			}

			user = new User();
			user.setUsername("nrahman");
			user.setFirstName("Nicole");
			user.setLastName("Rahman");
			user.setPassword("secret1");

			userService.addUser(user);

			Account account = new Account();
			account.setNumber("1111AAA");
			account.setCustomer(user.getUsername());
			account.setBalance(40000);

			accountService.addAccount(account);

			user = new User();
			user.setUsername("rrahman");
			user.setFirstName("Reza");
			user.setLastName("Rahman");
			user.setPassword("secret2");

			userService.addUser(user);

			account = new Account();
			account.setNumber("2222BBB");
			account.setCustomer(user.getUsername());
			account.setBalance(25000);

			accountService.addAccount(account);

			out.println("Done!");
		} finally {
			out.close();
		}
	}
}