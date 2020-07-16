package com.scl.aop.log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description 日志类
 **********************************/
@Aspect
public class MathLog {
    @Pointcut("execution(*  com.scl.aop.business.MathCalc.*(..))")
    public void ptr(){};
    @Before("ptr()")
    public void preLog(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("exec method before...........");
    }
    @After("ptr()")
    public void afterLog(){
        System.out.println("exec method after...........");
    }
    @AfterReturning("ptr()")
    public void returnLog(){
        System.out.println("exec method return...........");
    }

    @AfterThrowing("ptr()")
    public void exceptionLog(){
        System.out.println("exec method return...........");
    }

}
