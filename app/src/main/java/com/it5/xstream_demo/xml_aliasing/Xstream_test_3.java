package com.it5.xstream_demo.xml_aliasing;

import com.it5.xstream_demo.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Created by IT5 on 2016/11/14.
 */

public class Xstream_test_3 {
    private static Student getStudentDetails() {
        Student student=new Student("Mahesh","21");
        student.addNote(new Note("first","my first name!"));
        student.addNote(new Note("second","my second name!"));
        return student;
    }

    public static void main(String... args) {
        XStream xstream=new XStream(new DomDriver());
        Student student=getStudentDetails();
        //类混叠使用
        xstream.alias("student", Student.class);
        xstream.alias("note",Note.class);
        //字段混叠使用
        xstream.aliasField("name",Student.class,"studentName");
        //属性混叠使用
        xstream.aliasAttribute(Student.class,"studentName","name");
        xstream.aliasAttribute(Student.class,"age","age");
        //隐式集合混叠
        xstream.addImplicitCollection(Student.class, "notes");
        String xml=xstream.toXML(student);
        System.out.println(XmlUtil.formatXml(xml));
    }
}
