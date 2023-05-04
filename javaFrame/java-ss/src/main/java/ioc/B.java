package ioc;

public class B{

    private String name;
    private A a;
    public B(){

    }
    public B (A a){
        this.a = a;
    }
    public void test(){
        a.setId("111");
        System.out.println(a.getId());
    }

    public void test1(){
        a.setId("222");
        System.out.println(a.getId());
        System.out.println(1<0);
    }
}
