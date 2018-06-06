package com.acmebank.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.acmebank.domain.User;
import com.acmebank.service.UserService;

@Named
@SessionScoped
public class Login implements Serializable {
  private static final long serialVersionUID = 1L;

  @Inject
  private Credentials credentials;

  @Inject
  private UserService userService;

  private User user;

  public String login()
  {
    user = userService.getUser(credentials.getUsername());
    // Do a password check here...

    return "account.jsf";
  }

  @Named
  @Produces
  @LoggedIn
  public User getCurrentUser()
  {
    return user;
  }
}
