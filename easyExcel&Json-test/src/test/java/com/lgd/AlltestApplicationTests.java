package com.lgd;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.lgd.util.AESUtil;
import com.lgd.util.JsonUtil;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.DateFormatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class AlltestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test2(){
//        String a = "15138317311,13454133356,18334774241,13728729967,18074647589,15797691305,15757129641,15990096417,13588798183,13675861528,13003640942,13958040009,17764066449,15157136321";
        String a = "15168339582";
        String[] split = a.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for(String phone:split) {
            String encryptKey = "86436145d2ef42219ec17a341537b527";
            String encrypt = AESUtil.encryptString(phone, encryptKey);
            System.out.println(phone + " " + encrypt);
            stringBuilder.append("'" + encrypt+ "'" +",");
        }
        System.out.println(stringBuilder);
    }

    @Test
    void test3(){
        LocalTime firstBus = LocalTime.parse("08:30:00");
        LocalTime lastBus = LocalTime.parse("12:30:00");
        if (((firstBus.isAfter(LocalTime.now()) || lastBus.isBefore(LocalTime.now()))
                && (firstBus.isBefore(lastBus) ))
                ||
                (lastBus.isBefore(LocalTime.now()) && firstBus.isAfter(LocalTime.now()))
                        && (firstBus.isAfter(lastBus) )
        ) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    @Test
    void test(){
        /*Double b = new Double(0.295);
        BigDecimal bd = new BigDecimal(b.doubleValue() * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(String.valueOf(bd));
        */
        /*String s = "{\"code\":\"0\",\"msg\":\"\",\"response\":{\"discountPrice\":\"300\"}}";
        JSONObject json_test = JSONObject.parseObject(s);
        JSONObject response = json_test.getJSONObject("response");
        System.out.println(response.getString("discountPrice"));
        Integer discountPrice = Integer.valueOf(response.getString("discountPrice"));
        DecimalFormat df = new DecimalFormat("#.##");
        String platformPrice = df.format(discountPrice / 100);
        System.out.println(platformPrice);*/
        /*String a = "xxx(aaaaa--bbbbb)";
        String a2 = a.substring(a.lastIndexOf("(")+1,a.indexOf("--"));
        String a3 = a.substring(a.indexOf("--")+2,a.lastIndexOf(")"));
        String a4 = a.substring(0,a.indexOf("("));
        System.out.println(a4);
        System.out.println(a2);
        System.out.println(a3);*/
        /*String str = "(xxxxx)";
        String newNode;
        String allConvertNode;
        if (str.contains("(") && str.contains(")")) {
            newNode = str.replaceAll("\\(", "（");1131-===========]]]]]]]]]]]]\==-========================1


            allConvertNode = newNode.replaceAll("\\)", "）");
        } else if (str.contains("(") && !str.contains(")")) {
            allConvertNode = str.replaceAll("\\(", "（");
        } else if (!str.contains("(") && str.contains(")")) {
            allConvertNode = str.replaceAll("\\)", "）");
        } else {
            allConvertNode = str;
        }
        System.out.println(allConvertNode);*/
        /*String xlbMainLines = ",1001000057,1001000058,1001000079,1001000080,1001000063,1001000357,1001000358,3301000100121576,3301000100121577,3301000100134652,3301000100134653,3301000100135220,3301000100135221,3301000100092617,3301000100092616,";
        String[] xlbMainLine = xlbMainLines.substring(1).split(",");
        Arrays.stream(xlbMainLine).forEach(System.out::println);*/
        /*String s = String.valueOf((new BigDecimal("1000.3").divide(BigDecimal.valueOf(1000))));
        System.out.println(s);*/
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(2);
        ints.add(1);
        ints.add(4);
        ints.add(5);
        Integer flag = null;
        for(Integer num:ints){
            if (num.equals(1)){
                flag = num;
            }
        }
        if(flag != null) {
            ints.remove(flag);
            ints.add(0,flag);
        }
        ints.stream().forEach(System.out::println);
    }


    private boolean checkUrl(String url){
        if (!StringUtils.isEmpty(url)){
            String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(url);
            if (!m.matches()){
                return false;
            };
        }
        return true;
    }
}
