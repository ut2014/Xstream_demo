package com.it5.xstream_demo.xml_annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT5 on 2016/11/14.
 */
@XStreamAlias("student") //定义类的别名
public class Student {
    @XStreamAlias("name")//定义字段别名
    @XStreamAsAttribute //定义字段是个属性名
    public String studentName;
    @XStreamImplicit //定义集合是个隐式的
    public List<Note> notes = new ArrayList<>();
    @XStreamOmitField //定义一个忽略的字段
    private int type;

    public Student(String studentName) {
        this.studentName=studentName;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void setType(int type) {
        this.type=type;
    }

}
