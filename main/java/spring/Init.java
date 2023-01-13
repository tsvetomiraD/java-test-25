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
    @Qualifier("AClass")
    public AI getA(){
        return new A();
    }

    @Bean
    @Qualifier("BClass")
    public AI getB(){
        return new B();
    }

}
