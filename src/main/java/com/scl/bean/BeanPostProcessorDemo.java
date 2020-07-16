package com.scl.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author scl
 * @Date 2020/6/28
 * @Description
 */

public class BeanPostProcessorDemo implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if (bean instanceof Student){
           Student student = new Student();
           student.setName("za");
           student.setClassName("3.1");
//           System.out.println(student);
           return student;
       }
        return bean;
    }
}
