package com.lgd;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgd.pojo.LineSaveVO;
import com.lgd.pojo.LineVO;
import com.lgd.pojo.OrderToTrain;
import com.lgd.pojo.StopVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 10:30
 */
@SpringBootTest
public class JsonTests {


    @Test
    void readTest() throws IOException {
        String content = "";
        StringBuilder builder = new StringBuilder();

        File file = new File("E:\\IDEA\\alltest\\json\\test.json");
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        while ((content = bufferedReader.readLine()) != null)
            builder.append(content);

        List<LineVO> models = JSONArray.parseArray(builder.toString(), LineVO.class);
        List<LineSaveVO> list = new ArrayList<>();

        for(LineVO line:models){
            for (StopVO stop:line.getRound()){
                list.add(new LineSaveVO(line.getId(),line.getName(),line.getLinecolor(),stop.getId(),stop.getName()));
            }
        }

        saveDataToExcel(list);
    }

    @Test
    void readAll() throws IOException {
        String content = "";
        StringBuilder builder = new StringBuilder();

        File file = new File("E:\\IDEA\\alltest\\json\\allstop.json");
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        while ((content = bufferedReader.readLine()) != null)
            builder.append(content);

        List<LineVO> models = JSONArray.parseArray(builder.toString(), LineVO.class);
        //247个站
        List<LineSaveVO> list = new ArrayList<>();

//        saveDataToExcel();
    }

    void saveDataToExcel(List datas){
        // 写法2
        String saveFileName = "E:\\IDEA\\alltest\\exceltest\\lineStop(处理完).xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(saveFileName, LineSaveVO.class).sheet("sheet1").doWrite(datas);
    }

    @Test
    void tests(){
        String a = "abc";
        String[] x = new String[]{"a","b","c"};
        List<String> collect = Arrays.stream(x).collect(Collectors.toList());
        System.out.println(String.join(",",collect));
    }

}
