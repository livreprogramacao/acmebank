package com.acmebank.common;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Profiled
public class ProfilingInterceptor {

  @AroundInvoke
  public Object profile(InvocationContext context) throws Exception
  {
    Object value;

    long start = System.currentTimeMillis();
    value = context.proceed();
    long end = System.currentTimeMillis();

    System.out.println("Execution time for: " + context.getMethod().getName()
        + " was: " + (end - start) + " milliseconds");

    return value;
  }
}
