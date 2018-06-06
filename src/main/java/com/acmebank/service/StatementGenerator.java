package com.acmebank.service;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class StatementGenerator {

  @Schedule(second = "*/30", minute = "*", hour = "*")
  public void generateMonthlyStatements()
  {
    System.out.println("Generating monthly statements...");
  }
}