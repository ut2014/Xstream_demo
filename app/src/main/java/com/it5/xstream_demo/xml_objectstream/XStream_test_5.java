package com.it5.xstream_demo.xml_objectstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by IT5 on 2016/11/14.
 */

public class XStream_test_5 {
    public static void main(String... args) {
        XStream mXStream = new XStream(new DomDriver());
        mXStream.autodetectAnnotations(true);
        Student student1=new Student("ma0","ss0");
        Student student2=new Student("ma1","ss1");
        Student student3=new Student("ma2","ss2");
        Student student4=new Student("ma3","ss3");

        try {
            ObjectOutputStream os=mXStream.createObjectOutputStream(new FileOutputStream("text.txt"));
            os.writeObject(student1);
            os.writeObject(student2);
            os.writeObject(student3);
            os.writeObject(student4);
            os.writeObject("Hello World!");
            os.close();

            ObjectInputStream in=mXStream.createObjectInputStream(new FileInputStream("text.txt"));
            Student student5= (Student) in.readObject();
            Student student6= (Student) in.readObject();
            Student student7= (Student) in.readObject();
            Student student8= (Student) in.readObject();
            String txt= (String) in.readObject();
            System.out.println(student5);
            System.out.println(student6);
            System.out.println(student7);
            System.out.println(student8);
            System.out.println(txt);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
