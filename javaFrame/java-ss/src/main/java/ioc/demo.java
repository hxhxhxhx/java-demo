package ioc;

public class demo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.test();
        b.test1();
        System.out.println(b);
    }
}
