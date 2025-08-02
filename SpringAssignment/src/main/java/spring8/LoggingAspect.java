package spring8;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("Before Method is about to execute...");
    }

    public void logAfterReturning() {
        System.out.println("AfterReturning Method executed successfully.");
    }

    public void logAfterThrowing() {
        System.out.println("AfterThrowing Exception occurred during method execution.");
    }

    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around Starting method: " + pjp.getSignature().getName());
        long start =System.currentTimeMillis();

        Object result= pjp.proceed();

        long end=System.currentTimeMillis();
        System.out.println("Around Execution time: " + (end-start) + "ms");
        return result;
    }
}
