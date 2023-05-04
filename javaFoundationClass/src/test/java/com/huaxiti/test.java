package com.huaxiti;

import com.huaxiti.exception.FatherDemo;
import com.huaxiti.exception.SonDemo;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test {

    @Test
    public void testException(){
        SonDemo sonDemo = new SonDemo();
        sonDemo.method();

        FatherDemo fatherDemo = new FatherDemo();
        fatherDemo.method();
    }

    //两个元素相同，顺序不同的列表不相等
    @Test
    public void testCollectionEquals(){
        ArrayList<String> list1 = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
        }};

        ArrayList<String> list2 = new ArrayList<String>(){{
            add("3");
            add("2");
            add("1");
        }};

        System.out.println(list1.equals(list2));
    }

    @Test
    public void testStream() throws IOException {

        //读取文件
        File file = new File("E:\\11.txt");
        String fileName = file.getName();
        String filePath = file.getAbsolutePath();
        String[] split1 = filePath.split(fileName);
        String path = split1[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        //重名加后缀
        String newFileName = getName(fileName, path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + newFileName));

//        String res = "";
//        while((res = bufferedReader.readLine()) != null){
//            bufferedWriter.write(res+"\n");
//            bufferedWriter.flush();
//        }
        char[] by = new char[1024];
        int res = 0;
        while((res = bufferedReader.read(by)) != -1){
            bufferedWriter.write(by,0,res);
            bufferedWriter.flush();
        }
        bufferedWriter.close();


//        new DataInputStream(new FileInputStream(filePath));
//        byte[] ab = {};
//        BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new ByteArrayInputStream(ab));
//        bufferedInputStream1.read(by);
//
//        BufferedReader bufferedReader1 = new BufferedReader(new StringReader("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"));
//        System.out.println(bufferedReader1.readLine());
    }

    @Test
    public void testByteStream() throws IOException {
        //读取文件
        File file = new File("E:\\11.txt");
        String fileName = file.getName();
        String filePath = file.getAbsolutePath();
        String[] split1 = filePath.split(fileName);
        String path = split1[0];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        String newFileName = getName(fileName, path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path + newFileName));

        byte[] by = new byte[1024];
        int num = 0;
        while((num = bufferedInputStream.read(by)) != -1){
            bufferedOutputStream.write(by,0,num);
            bufferedOutputStream.flush();
        }
//        bufferedOutputStream.close();
    }

    private String getName(String fileName, String path) {
        String[] split = fileName.split("\\.");
        String newFileName = split[0] + "("+0+")." + split[1];
        int i = 0;
        while (new File(path + newFileName).exists()){
            i++;
            newFileName = split[0] + "("+i+")." + split[1];
        }
        return newFileName;
    }

    @Test
    public void testArray(){
        char[] a = new char[]{'a', 'b', 'c'};
        System.out.println(String.valueOf(a));
    }

    @Test
    public void testObjectStream() throws IOException, ClassNotFoundException {
        Student student = new Student("zhangsan",18);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(""));
        objectOutputStream.writeObject(student);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
//        objectInputStream.readObject()
    }
}

class Student{
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
