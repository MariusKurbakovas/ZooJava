package zoopark.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LogAspect
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception{
        System.out.println("Method called: " + context.getMethod().getName());
        return context.proceed();
    }
}
