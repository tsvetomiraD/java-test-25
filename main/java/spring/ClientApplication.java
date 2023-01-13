package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Init.class, AI.class);
        MyApplication app = context.getBean(MyApplication.class);

        System.out.println(app.processA("Hi Pankaj"));
        app.processB("Hi Pankaj");

        //close the context
        context.close();
    }

}