package spring;

import org.springframework.beans.factory.annotation.Autowired;

interface AI {
    String msg(String msg);
}
class A implements AI {
    public String msg(String msg) {
        return "Message send for A class: " + msg;
    }
}

class B implements AI{
    @Autowired
    public A aField;
    public String msg(String msg) {
        return "Message send for B class: " + msg;
    }
}

class C {
    @Autowired
    B bField;
}

interface DI {
}

class D implements DI {
}

class E implements DI {
}
