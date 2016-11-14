package com.it5.xstream_demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by IT5 on 2016/11/14.
 */

public class XmlUtil {
    //格式化xml 主要是生成格式头 <?xml version="1.0" encoding="UTF-8"?>
    public static String formatXml(String xml){
        try{
            Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res =  new StreamResult(new ByteArrayOutputStream());
            serializer.transform(xmlSource, res);
            return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
        }catch(Exception e){
            return xml;
        }
    }


    /**
     * java 转换成xml
     * @Title: toXml
     * @Description: TODO
     * @param obj 对象实例
     * @return String xml字符串
     */
    public static String toXml(Object obj){
        XStream xstream=new XStream();
//          XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
//          XStream xstream=new XStream(new DomDriver("utf-8")); //指定编码解析器,直接用jaxp dom来解释

        ////如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
        xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
        return xstream.toXML(obj);
    }


    /**
     * 将传入xml文本转换成Java对象
     */
    public static <T> T toBean(String xmlStr, Class<T> cls) {
        //注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError:
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(cls);
        T obj= (T) xStream.fromXML(xmlStr);
        return obj;
    }

    /**
     * 写到xml文件中去
     */
    public static boolean toXMLFile(Object obj, String absPath, String fileName ){
        String strXml = toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
//                log.error("创建{"+ filePath +"}文件失败!!!" + Strings.getStackTrace(e));
                return false ;
            }
        }// end if
        OutputStream ous = null ;
        try {
            ous = new FileOutputStream(file);
            ous.write(strXml.getBytes());
            ous.flush();
        } catch (Exception e1) {
//            log.error("写{"+ filePath +"}文件失败!!!" + Strings.getStackTrace(e1));
            return false;
        }finally{
            if(ous != null )
                try {
                    ous.close();
                } catch (IOException e) {
//                    log.error("写{"+ filePath +"}文件关闭输出流异常!!!" + Strings.getStackTrace(e));
                }
        }
        return true ;
    }


    /**
     * 从xml文件读取报文
     * @Title: toBeanFromFile
     * @Description: TODO
     * @param absPath 绝对路径
     * @param fileName 文件名
     * @param cls
     * @throws Exception
     * @return T
     */
    public static <T> T  toBeanFromFile(String absPath, String fileName,Class<T> cls) throws Exception{
        String filePath = absPath +fileName;
        InputStream ins = null ;
        try {
            ins = new FileInputStream(new File(filePath ));
        } catch (Exception e) {
            throw new Exception("读{"+ filePath +"}文件失败！", e);
        }

//        String encode = useEncode(cls);
        XStream xstream=new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(cls);
        T obj =null;
        try {
            obj = (T)xstream.fromXML(ins);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new Exception("解析{"+ filePath +"}文件失败！",e);
        }
        if(ins != null)
            ins.close();
        return obj;
    }

    public static <T> T toBeanFromFile(String fileName, Class<T> cls) throws Exception{
        if (fileName==null) {
            return null;
        }
        InputStream ins = null ;
        try {
            ins = new FileInputStream(fileName);
        } catch (Exception e) {
            throw new Exception("读{"+ fileName +"}文件失败！", e);
        }

//        String encode = useEncode(cls);
        XStream xstream=new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(cls);
        T obj =null;
        try {
            obj = (T)xstream.fromXML(ins);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new Exception("解析{"+ fileName +"}文件失败！",e);
        }
        if(ins != null)
            ins.close();
        return obj;
    }
}
