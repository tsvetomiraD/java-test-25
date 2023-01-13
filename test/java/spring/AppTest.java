package spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    AnnotationConfigApplicationContext context;
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(Init.class);
    }

    @Test
    public void testTwoInstancesMyApplication() {
        MyApplication app = context.getBean(MyApplication.class);
        MyApplication app2 = context.getBean(MyApplication.class);
        assertEquals(app, app2);
    }

    @Test
    public void testTwoInstancesAClass() {
        MyApplication app = context.getBean(MyApplication.class);
        AI a1 = app.classA;
        MyApplication app2 = context.getBean(MyApplication.class);
        AI a2 = app2.classA;
        assertEquals(a1, a2);
    }

    @Test
    public void testQualifier() {
        MyApplication app = context.getBean(MyApplication.class);
        AI a = app.classA;
        AI b = app.classB;
        assertNotEquals(a, b);
    }

    @Test
    public void testRightMsg() {
        MyApplication app = context.getBean(MyApplication.class);
        String expected = "Message send for A class: Hi Pankaj";
        assertEquals(expected, app.processA("Hi Pankaj"));
    }
}
