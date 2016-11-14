package com.it5.xstream_demo.xml_2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import static com.it5.xstream_demo.XmlUtil.formatXml;

/**
 * Created by IT5 on 2016/11/14.
 */

public class Xstream_Test {
    public static void main(String... args){
        XStream xstream=new XStream(new DomDriver());
        Student student=getStudentDetail();
        //类混叠是用来创建一个类的XML完全限定名称的别名。添加代码。去掉全包名
        xstream.alias("student", Student.class);
        String xml=xstream.toXML(student);
        System.out.println(formatXml(xml));
    }

    private static Student getStudentDetail(){
        Student student=new Student();
        student.setFirstName("Mahesh");
        student.setLastName("Parashar");
        student.setRollNo(1);

        Address address=new Address();
        address.setArea("h.no. preet vihar.");
        address.setCity("delhi");
        address.setState("india");
        address.setPincode(12211);
        student.setAddress(address);
        return student;
    }


}
