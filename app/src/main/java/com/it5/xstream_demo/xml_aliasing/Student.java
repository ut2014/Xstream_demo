package com.it5.xstream_demo.xml_aliasing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT5 on 2016/11/14.
 */

public class Student {
    public String studentName;
    public String age;
    public List<Note> notes=new ArrayList<>();

    public Student(String name,String age) {
        this.studentName = name;this.age=age;
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}
