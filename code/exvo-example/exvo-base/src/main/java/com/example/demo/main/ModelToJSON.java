package com.example.demo.main;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.SaveTravelApplyRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Date: 2018/11/6
 * @Author: wu yang
 * @Description:model转json
 */
public class ModelToJSON {

    public static void main(String[] args) {
        SaveTravelApplyRequest request = new SaveTravelApplyRequest();
        request = (SaveTravelApplyRequest) setObjectValue(request);
        /** 如果不赋值只会转有默认值的属性 **/
        System.out.println(modelToJsonForFastJson(request));
    }

    /**
     * fasfJson
     *
     * @param obj
     * @return
     */
    public static String modelToJsonForFastJson(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    /**
     * Gson
     *
     * @param obj
     * @return
     */
    public static String modelToJsonForGson(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
//        gson.fromJson("JSON字符串", "类名.class");  将json字符串转成对象
        return gson.toJson(obj);
    }

    /**
     * 动态给对象赋值
     *
     * @param obj
     * @return
     */
    public static Object setObjectValue(Object obj) {

        //获取属性
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                //设置属性的访问权限为可访问
                f.setAccessible(true);
                //判断属性的类型
                if (f.getType().toString().equals("class java.lang.String")) {
                    f.set(obj, "");
                }
                if (f.getType().toString().equals("class java.util.Date")) {
                    f.set(obj, new Date());
                }
                if (f.getType().toString().equals("interface java.util.List")) {
                    f.set(obj, new ArrayList<>());
                    //获取泛型的类型
                    Type genericType = f.getGenericType();
                    if (genericType != null) {
                        if (genericType instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) genericType;
                            Type type = parameterizedType.getActualTypeArguments()[0];
                            // class com.example.demo.model.TravelPassengerRequest
                            Object object = Class.forName(String.valueOf(type).split(" ")[1]);
                            //TODO 如何把泛型的object放入 这个字段中？？

                        }
                    }
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
