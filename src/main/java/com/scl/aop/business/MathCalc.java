package com.scl.aop.business;


import org.springframework.stereotype.Component;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description aop
 *  1、导入依赖
 *  2、定义业务逻辑类
 *  3、定义切面类
 *      编写通知方法
 *  4、给切面类的方法加上注解（何时执行）
 *  5、将切面和业务逻辑加入容器
 *  6、标志该类是切面类（@Aspect）
 *  7、开启注解切面的功能(@EnableAspectJAutoProxy)
 *
 **********************************/
public class MathCalc {
    static {
        System.out.println("MathCalc 被加载了");
    }
    public MathCalc(){
        System.out.println("MathCalc 被实例化了");
    }
    /**
     * @param n
     * @param m
     * @param execInstruction
     * @return
     */
    public int calc(int n, int m, int execInstruction) {
        switch (execInstruction) {
            case Instruction.ADD:
                return n + m;
            case Instruction.DIV:
                return n / m;
            case Instruction.MUL:
                return n * m;
            case Instruction.SUB:
                return n - m;
            default:
                throw new IllegalArgumentException("execInstruction is not valid");
        }
    }

    public static final class Instruction {
        public static final int ADD = 1;
        public static final int SUB = 2;
        public static final int DIV = 3;
        public static final int MUL = 4;
    }

}
