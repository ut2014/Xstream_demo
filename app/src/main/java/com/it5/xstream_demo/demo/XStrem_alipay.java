package com.it5.xstream_demo.demo;

import com.it5.xstream_demo.XmlUtil;

/**
 * Created by IT5 on 2016/11/14.
 */

public class XStrem_alipay {
    public static void main(String... args) {
        try {
            Alipay alipay= XmlUtil.toBeanFromFile("xml.txt",Alipay.class);
            System.out.println(alipay);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
