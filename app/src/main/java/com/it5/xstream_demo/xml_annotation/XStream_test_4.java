package com.it5.xstream_demo.xml_annotation;

import com.it5.xstream_demo.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Created by IT5 on 2016/11/14.
 */

public class XStream_test_4 {

    public static void main(String... args) {
        XStream xStream=new XStream(new DomDriver());
        //通知框架来处理注解
        xStream.processAnnotations(Student.class);
        //或者
//        xStream.autodetectAnnotations(true);
        String xml=xStream.toXML(getSutentDetails());
        System.out.println(XmlUtil.formatXml(xml));
    }

    private static Student getSutentDetails() {
        Student student=new Student("Mans");
        student.addNote(new Note("first","this first name"));
        student.addNote(new Note("second","the second name"));
        student.setType(1);
        return student;
    }
}
