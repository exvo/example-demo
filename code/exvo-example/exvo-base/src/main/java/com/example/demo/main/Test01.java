package com.example.demo.main;

import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date: 2019/4/2
 * @Author: wu yang
 * @Description:
 */
public class Test01 {

    static String sql = "INSERT INTO `t_base_data`(`code`,`value`,`org_code`,`category`,`category_name`,`category_sequence`,`memo`,`status`,`create_by`,`create_at`,`modify_by`,`modify_at`)                         " +
            "VALUES ('%s','%s','0','loan_fee_type','借款费用类型',%d,'%s',2,'sys','2019-04-02 00:00:00','sys','2019-04-02 00:00:00');";

    public static void main(String[] args) {
        String names = "偿还借款," +
                "分配利润," +
                "筹资费用," +
                "支付利息," +
                "其他       ," +
                "进口关税及增值税  ," +
                "应付票据," +
                "广告费," +
                "安维费," +
                "销售运费," +
                "工资福利," +
                "租金及装卸费," +
                "税费," +
                "水电费," +
                "佣金," +
                "其他," +
                "基建工程," +
                "固定资产购进," +
                "权益性投资," +
                "无形资产," +
                "债权性投资," +
                "其他投资活动";

        /*String[] split = names.split(",");
        String codeTemp = "B%02d";
        for (int i = 0; i < split.length; i++) {
            String format = String.format(sql, String.format(codeTemp, i+1), split[i], i * 5);
            System.out.println(format);
        }*/
        /*FeeType[] values = FeeType.values();
        for (int i = 0; i < values.length; i++) {
            String format = String.format(sql, String.format( values[i].getCode(), i+1), values[i].getName(), i * 5, values[i].getKeyword());
            System.out.println(format);
        }*/

//        String a = "好的出s口啊呀";
//        System.out.println(a.contains("出口"));

        /*String str = "123|erere|454";
        String[] split = str.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }*/

        String[] a = {"a", "a", "a", "a"};
        String[] b = {"b", "b", "b", "b"};
        String[] c = {"c", "c", "c", "c"};
        String[] d = {"d", "d", "d", "d"};

        List<String[]> list1 = new ArrayList<>();
        list1.add(b);
        list1.add(c);

        List<String> res = new ArrayList<>();
        res.addAll(Arrays.asList(a));
        res.addAll(Arrays.asList(b));
        res.addAll(Arrays.asList(d));
        list1.forEach(l -> {
            for (int i = 0; i < l.length; i++) {
                res.add(l[i]);
            }
        });

//        res.forEach(r -> System.out.println(r));
//        String[] dd = res.stream().toArray(String[]::new);
//        System.out.println(dd);

        String str = "nihao%d（wrrew）";
        if (str.contains("%d")) {
            str = String.format(str, 2);
        }
        System.out.println(str);

    }


}
