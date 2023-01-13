package spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class TestSWithException {
    AnnotationConfigApplicationContext context;

    @Test(expected = NullPointerException.class)
    public void testWithoutAutowired() {
        context = new AnnotationConfigApplicationContext(Init.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processA("something");
    }

    @Test(expected = UnsatisfiedDependencyException.class)
    public void testWithoutBean() {
        context = new AnnotationConfigApplicationContext(Init.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processA("something");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testWithoutComponentScan() {
        context = new AnnotationConfigApplicationContext(Init.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processA("something");
    }

    @Test(expected = UnsatisfiedDependencyException.class)
    public void testWithoutQualifierInInit() {
        context = new AnnotationConfigApplicationContext(Init.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processA("something");
    }

    @Test(expected = UnsatisfiedDependencyException.class)
    public void testWithoutQualifierInMyApp() {
        context = new AnnotationConfigApplicationContext(Init.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processA("something");
    }

    @Test
    public void testWrongFieldTypeClassB() {
        Exception e = assertThrows(UnsatisfiedDependencyException.class, () -> context = new AnnotationConfigApplicationContext(Init.class));
        //context = new AnnotationConfigApplicationContext(Init.class);
        assertTrue(e.getMessage().contains("Unsatisfied dependency expressed through field 'classB':"));
    }

    @Test
    public void testWrongFieldTypeClassA() {
        Exception e = assertThrows(UnsatisfiedDependencyException.class, () -> context = new AnnotationConfigApplicationContext(Init.class));
        //context = new AnnotationConfigApplicationContext(Init.class);
        assertTrue(e.getMessage().contains("Error creating bean with name 'myApplication': Unsatisfied dependency expressed through field 'classA':"));
    }
    @Test
    public void testPassInterfaceToConstructor() {
        Exception e = assertThrows(BeanCreationException.class, () -> context = new AnnotationConfigApplicationContext(Init.class, AI.class));
        //context = new AnnotationConfigApplicationContext(Init.class);
        assertTrue(e.getMessage().contains("Error creating bean with name 'AI': Failed to instantiate [spring.AI]: Specified class is an interface"));
    }
}
