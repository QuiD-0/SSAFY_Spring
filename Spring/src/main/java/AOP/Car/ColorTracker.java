package AOP.Car;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class ColorTracker {

    @Before("execution(void set*(*))")  //pointcut
    public void setColorTracker(JoinPoint joinPoint) {  //advice
        System.out.println("before advice 시작");
        System.out.println("target :" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("method :" + joinPoint.getSignature().getName());
        System.out.println("args :" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before advice 종료");
    }

    @After("execution(String get*())")  //pointcut
    public void getColorTracker(JoinPoint joinPoint) {  //advice
        System.out.println("after advice 시작");
        System.out.println("target :" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("method :" + joinPoint.getSignature().getName());
        System.out.println("args :" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("after advice 종료");
    }

}
