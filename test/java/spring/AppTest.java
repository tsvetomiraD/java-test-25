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
    public void testGetBeanNotNull() {
        MyApplication app = context.getBean(MyApplication.class);

        assertNotNull(app);
    }
    @Test
    public void testTwoInstancesMyApplication() {
        MyApplication app = context.getBean(MyApplication.class);
        MyApplication app2 = context.getBean(MyApplication.class);

        assertNotNull(app);
        assertEquals(app, app2);
    }

    @Test
    public void testTwoInstancesAClass() {
        MyApplication app = context.getBean(MyApplication.class);
        AI a1 = app.classA;
        MyApplication app2 = context.getBean(MyApplication.class);
        AI a2 = app2.classA;

        assertNotNull(a1);
        assertEquals(a1, a2);
    }

    @Test
    public void testQualifier() {
        MyApplication app = context.getBean(MyApplication.class);
        DI d = app.classD;
        DI e = app.classE;

        assertNotNull(d);
        assertNotNull(e);
        assertNotEquals(d, e);
    }

    @Test
    public void testRightMsg() {
        MyApplication app = context.getBean(MyApplication.class);
        String expected = "Message send for A class: Hi";

        assertEquals(expected, app.processA("Hi"));
    }

    @Test
    public void testAfieldInBClassNotNull() {
        MyApplication app = context.getBean(MyApplication.class);
        A classAInB = app.classB.aField;

        assertNotNull(classAInB);
    }

    @Test
    public void testAfieldInBClassEqualsWithAClass() {
        MyApplication app = context.getBean(MyApplication.class);
        A classA = app.classA;
        A classAInB = app.classB.aField;

        assertNotNull(classAInB);
        assertEquals(classA, classAInB);
    }

    @Test
    public void testClassFieldClassWithFieldClass() {
        MyApplication app = context.getBean(MyApplication.class);
        C classC = app.classC;
        A classA = app.classA;
        A classAInBInC = classC.bField.aField;

        assertNotNull(classAInBInC);
        assertEquals(classA, classAInBInC);
    }
}
