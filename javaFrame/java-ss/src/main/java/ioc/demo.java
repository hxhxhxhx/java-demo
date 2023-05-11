package ioc;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
//        A a = new A();
//        B b = new B(a);
//        b.test();
//        b.test1();
//        System.out.println(b);
        Resource resource = new Resource();
        resource.setId("333");
        resource.setName("nnn");
        File file = new File();
        file.setName("f11");
        File file1 = new File();
        file.setName("f2");
        List<File> list = new ArrayList<File>();
        list.add(file);
        list.add(file1);
        resource.setFileList(list);

        HashMap<String, Object> map = new HashMap<>();
        Field[] fields =resource.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            try {
                map.put(new String(field.getName()),field.get(resource));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(map);
    }
}
