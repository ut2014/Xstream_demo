package com.it5.xstream_demo.xml_annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by IT5 on 2016/11/14.
 */
@XStreamAlias("note")
public class Note {
    public String title;
    public String description;

    public Note(String title, String description) {
        this.description = description;
        this.title = title;
    }
}
