package AOP.Board;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class BoardTracker {

    @Before("execution(void *(*))")
    public void Tracking1(JoinPoint joinPoint){
        System.out.println("before advice 시작");
        System.out.println("target :" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("method :" + joinPoint.getSignature().getName());
        System.out.println("args :" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("before advice 종료");
    }

    @After("execution(String read(*))")
    public void tarcking2(JoinPoint joinPoint){
        System.out.println("after advice 시작");
        System.out.println("target :" + joinPoint.getTarget().getClass().getSimpleName());
        System.out.println("method :" + joinPoint.getSignature().getName());
        System.out.println("args :" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("after advice 종료");
    }
}
