package spring;

interface AI {
    String msg(String msg);
}
class A implements AI {
    public String  msg(String msg) {
        return "Message send for A class: " + msg;
    }
}

class B implements AI{
    A aField;
    public String  msg(String msg) {
        return "Message send for B class: " + msg;
    }
}

class C {
    B bField;
}

interface DI {
}

class D implements DI {
}

class E {
    A aField;

    public E(A afield) {
        this.aField = afield;
    }
}

class F {
    A iname;
}

class FS {
    String email;
}

class FSI implements Initializer {
    String email;

    @Override
    public void init() throws Exception {
        email = "mailto:" + email;
    }
}

interface Initializer {
    public void init() throws Exception;
}