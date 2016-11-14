package com.it5.xstream_demo.demo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

import java.util.List;

/**
 * Created by IT5 on 2016/11/14.
 */
@XStreamAlias("alipay")
public class Alipay {
    private String is_success;
    private String sign;
    private String sign_type;

    public Request request;
    public Response response;

    @Override
    public String toString() {
        return "Alipay{" +
                "is_success='" + is_success + '\'' +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
@XStreamAlias("request")
class Request{
    // @XStreamImplicit(itemFieldName = "param")
    @XStreamImplicit(itemFieldName = "param")
    public List<Param> params;

    public Request(List<Param> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Request{" +
                "param=" + params +
                '}';
    }
}
@XStreamAlias("trade")
class Trade{
    private String total_fee;
    private String trade_no;
    private String trade_status;
    private String use_coupon;

    @Override
    public String toString() {
        return "Trade{" +
                "total_fee='" + total_fee + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", use_coupon='" + use_coupon + '\'' +
                '}';
    }
}

/**
 * ToAttributedValueConverter 取得value值
 * 解释格式 如 <param name="_input_charset">utf-8</param>
 * 用@XStreamConverter(value=ToAttributedValueConverter.class, strings={"param"})
 * strings={"param"}中的param来接收xml中param中的值utf-8
 */
//@XStreamAlias("param")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"param"})
class Param{
    @XStreamAsAttribute()
    private String name;

    public String param;

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}

@XStreamAlias("response")
class  Response{
    private Trade trade;

    @Override
    public String toString() {
        return "Response{" +
                "trade=" + trade +
                '}';
    }
}