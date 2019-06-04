package com.example.demo.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.demo.generic.model.Panda;
import com.example.demo.model.Student;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Date: 2019/3/18
 * @Author: wu yang
 * @Description:
 */
public class JSONTest {

    private static final String jsonStr = "{\"Message\":\"识别成功\"," +
            "\"Data\":" +
                "{\"invoice_code2\":" +
                    "{\"score\":1.0,\"chinese_key\":\"发票代码2\",\"words\":\"1100183130\",\"position\":" +
                        "{\"top\":106,\"left\":135,\"width\":169,\"height\":26}" +
                    "},\"invoice_code1\":{\"score\":1.0,\"chinese_key\":\"发票代码1\",\"words\":\"1100183130\",\"position\":{\"top\":106,\"left\":135,\"width\":169,\"height\":26}},\"creator\":{\"score\":1.0,\"chinese_key\":\"开票人\",\"words\":\"时阳\",\"position\":{\"top\":636,\"left\":613,\"width\":36,\"height\":16}},\"buyer_address\":{\"score\":1.0,\"chinese_key\":\"购方地址电话\",\"words\":\"广东省珠海市前山会鸡西路0756-8614883\",\"position\":{\"top\":251,\"left\":194,\"width\":312,\"height\":16}},\"seller_bank_info\":{\"score\":1.0,\"chinese_key\":\"销方开户行及账号\",\"words\":\"北京通结交口支行01091200100120106030500\",\"position\":{\"top\":616,\"left\":205,\"width\":335,\"height\":20}},\"receiver\":{\"score\":1.0,\"chinese_key\":\"收款人\",\"words\":\"\",\"position\":{\"top\":627,\"left\":81,\"width\":240,\"height\":122}},\"amount_small\":{\"score\":1.0,\"chinese_key\":\"价税合计（小写）\",\"words\":\"2296.00\",\"position\":{\"top\":496,\"left\":762,\"width\":218,\"height\":54}},\"qrcode\":{\"score\":1.0,\"chinese_key\":\"二维码\",\"words\":\"\",\"position\":{\"top\":0,\"left\":0,\"width\":0,\"height\":0}},\"buyer_bank_info\":{\"score\":1.0,\"chinese_key\":\"购方开户行及账号\",\"words\":\"农业银行珠海市分行营业部44350101040003104\",\"position\":{\"top\":277,\"left\":194,\"width\":356,\"height\":16}},\"buyer_name\":{\"score\":1.0,\"chinese_key\":\"购方名称\",\"words\":\"金海北力电器股份有限公司\",\"position\":{\"top\":200,\"left\":192,\"width\":191,\"height\":18}},\"check\":{\"score\":1.0,\"chinese_key\":\"复核\",\"words\":\"主秀门\",\"position\":{\"top\":640,\"left\":379,\"width\":46,\"height\":16}},\"total_tax\":{\"score\":1.0,\"chinese_key\":\"合计税额\",\"words\":\"66.87\",\"position\":{\"top\":442,\"left\":820,\"width\":160,\"height\":68}},\"seller_address\":{\"score\":1.0,\"chinese_key\":\"销方地址电话\",\"words\":\"北京海*技信车息门内业小西有国三参八号010-54915701\",\"position\":{\"top\":594,\"left\":204,\"width\":334,\"height\":19}},\"amount_big\":{\"score\":1.0,\"chinese_key\":\"价税合计（大写）\",\"words\":\"贰仟贰佰玖拾陆圆整\",\"position\":{\"top\":513,\"left\":304,\"width\":182,\"height\":22}},\"total\":{\"score\":1.0,\"chinese_key\":\"合计金额\",\"words\":\"2229.13\",\"position\":{\"top\":479,\"left\":696,\"width\":86,\"height\":16}},\"password_area\":{\"score\":1.0,\"chinese_key\":\"密码区\",\"words\":\"9*+2*/97/262<1-427-<6/05-0893/*04><97-83>05-09*/146802*90*880*9*6-346><57326+<<>490*-1>*00<*-6>87/24>*>+4*1\",\"position\":{\"top\":204,\"left\":613,\"width\":312,\"height\":75}},\"seller_name\":{\"score\":1.0,\"chinese_key\":\"销方名称\",\"words\":\"北京人泉人社章有限公司\",\"position\":{\"top\":550,\"left\":202,\"width\":187,\"height\":19}},\"buyer_tax_no\":{\"score\":1.0,\"chinese_key\":\"购方纳税人识别号\",\"words\":\"91440400192548256N\",\"position\":{\"top\":226,\"left\":208,\"width\":250,\"height\":17}},\"seller_tax_no\":{\"score\":1.0,\"chinese_key\":\"销方纳税人识别号\",\"words\":\"911101017704263821\",\"position\":{\"top\":572,\"left\":224,\"width\":244,\"height\":21}},\"check_code\":{\"score\":1.0,\"chinese_key\":\"校验码\",\"words\":\"\",\"position\":{\"top\":0,\"left\":0,\"width\":999,\"height\":749}},\"create_date\":{\"score\":1.0,\"chinese_key\":\"开票日期\",\"words\":\"2019年04月1日\",\"position\":{\"top\":159,\"left\":827,\"width\":115,\"height\":18}},\"invoice_no2\":{\"score\":1.0,\"chinese_key\":\"发票号码2\",\"words\":\"24701008\",\"position\":{\"top\":135,\"left\":875,\"width\":83,\"height\":16}},\"invoice_no1\":{\"score\":1.0,\"chinese_key\":\"发票号码1\",\"words\":\"24701008\",\"position\":{\"top\":104,\"left\":700,\"width\":177,\"height\":26}}},\"StatusCode\":0,\"Success\":true}";

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            double random = Math.random();
            System.out.println(random);
            System.out.println((int) ((random + 1) * 10000));
            System.out.println("---------------");
        }
    }

}
