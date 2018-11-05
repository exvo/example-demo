package com.example.demo.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) {
        //包含
        contains();
        //是否为汉字
        vd("asdsa");
        isChineseChar("张家口asddfdf");
    }

    /**
     * 包含
     */
    public static void contains() {
        System.out.println("------------------包含");
        String str = "zhangjiakou";
        System.out.println(str.contains("zha"));
        System.out.println();
    }

    /**
     * 是否为汉字
     * @param str
     * @return
     */
    public static void vd(String str){
        System.out.println("------------------是否为汉字");
        char[] chars=str.toCharArray();
        boolean isGB2312=false;
        for(int i=0;i<chars.length;i++){
            byte[] bytes=(""+chars[i]).getBytes();
            if(bytes.length==2){
                int[] ints=new int[2];
                ints[0]=bytes[0]& 0xff;
                ints[1]=bytes[1]& 0xff;

                if(ints[0]>=0x81 && ints[0]<=0xFE &&
                        ints[1]>=0x40 && ints[1]<=0xFE){
                    isGB2312=true;
                    break;
                }
            }
        }
        System.out.println(str + "   是否为汉字：" + isGB2312);
        System.out.println();
    }

    // 判断是否为汉字
    public static boolean isChineseChar(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        System.out.println(temp);
        return temp;
    }

}
