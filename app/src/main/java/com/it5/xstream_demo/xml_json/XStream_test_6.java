package com.it5.xstream_demo.xml_json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import java.io.Writer;

/**
 * Created by IT5 on 2016/11/14.
 */

public class XStream_test_6 {
    public static void main(String... args) {
        XStream xStream=new XStream(new JsonHierarchicalStreamDriver(){
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new JsonWriter(out, JsonWriter.DROP_ROOT_MODE);
            }
        });

        Student student=new Student("ss","ssss");
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("student",Student.class);
        System.out.println(xStream.toXML(student));
    }
}
