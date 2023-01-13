package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {
    @Autowired
    @Qualifier("AClass")
    public AI classA;

    @Autowired
    @Qualifier("BClass")
    public AI classB;

    public String processA(String msg){
        //some magic like validation, logging etc
        return this.classA.msg(msg);
    }
    public String processB(String msg){
        //some magic like validation, logging etc
        return this.classB.msg(msg);
    }

}