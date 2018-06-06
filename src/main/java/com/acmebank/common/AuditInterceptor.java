package com.acmebank.common;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Audited
public class AuditInterceptor {

  @AroundInvoke
  public Object audit(InvocationContext context) throws Exception
  {
    System.out.print("Executing: " + context.getMethod().getName());
    System.out.println(" with args: "
        + Arrays.toString(context.getParameters()));

    return context.proceed();
  }
}
