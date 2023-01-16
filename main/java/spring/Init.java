package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"spring"})
public class Init {
    @Bean
    public A getA(){
        return new A();
    }

    @Bean
    public B getB(){
        return new B();
    }

    @Bean
    public C getC(){
        return new C();
    }

    @Bean
    @Qualifier("DClass")
    public DI getD(){
        return new D();
    }

    @Bean
    @Qualifier("EClass")
    public DI getE(){
        return new E();
    }
}
