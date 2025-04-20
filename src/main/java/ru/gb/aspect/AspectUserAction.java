package ru.gb.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectUserAction {

    @Around("@annotation(trackUserAction)")
    public Object aspectUserTrack(org.aspectj.lang.ProceedingJoinPoint joinPoint,
                                  TrackUserAction trackUserAction) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String methodName = methodSignature.getName();
        Object[] args = joinPoint.getArgs();
        String actionDescription = trackUserAction.value();

        System.out.println("Действие: " + actionDescription);
        System.out.println("Метод: " + methodName);
        System.out.print("Аргументы: ");
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();

        return joinPoint.proceed();
    }

}
