package utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @Date: 2019/4/19
 * @Author: wu yang
 * @Description: 拼音工具类
 */
public class PingYinUtils {

    /**
     * 返回一个拼音字符串，并且首字母大写
     * @param src
     * @return
     */
    public static String getPingYin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0].substring(0, 1).toUpperCase() + t2[0].substring(1);
                    ;
                } else {
                    t4 += java.lang.Character.toString(t1[i]);
                }
            }


        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;

    }

    /**
     * 返回中文的大写首字母
     * @param str
     * @return
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].toUpperCase().charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    public static void main(String[] args) {
        String[] cities = {"北京市", "朝阳区", "上海市", "浦东新区", "郧阳区"};

        for (String city : cities) {

            if (city.endsWith("市")) {
                city = city.substring(0, city.length() - 1);
            }
            System.out.print(city);
            String pingYin = getPingYin(city);
            System.out.print("----------------" + pingYin.toLowerCase());

            String head = getPinYinHeadChar(city);
            System.out.print("----------------" + head);

            System.out.println();
        }

    }

}
