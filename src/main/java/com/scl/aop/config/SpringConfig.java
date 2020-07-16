package com.scl.aop.config;

import com.scl.aop.business.MathCalc;
import com.scl.aop.log.MathLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {
    @Bean
    public MathCalc mathCalc(){
        return new MathCalc();
    }

    @Bean
    public MathLog mathLog(){
        return new MathLog();
    }

}
