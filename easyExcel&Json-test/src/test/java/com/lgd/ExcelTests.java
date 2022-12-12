package com.lgd;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.lgd.pojo.DemoData;
import com.lgd.pojo.OrderToTrain;
import com.lgd.pojo.PhoneAndMi;
import com.lgd.pojo.StopIdVO;
import com.lgd.util.AESUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 10:24
 */
@SpringBootTest
public class ExcelTests {

    private final static Logger log = Logger.getLogger(String.valueOf(ExcelTests.class));

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void generateStopId(){
        String fileName = "E:\\IDEA\\alltest\\exceltest\\trainCode.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, StopIdVO.class, new ReadListener<StopIdVO>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 800;
            /**
             *临时存储
             */
            private List<StopIdVO> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(StopIdVO data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                    ArrayList<Object> objects = new ArrayList<>();
                }
            }

            //解析完后做什么
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                int order = 0;
                Map<String,Integer> hashMap = new HashMap<>();
                for (StopIdVO data :cachedDataList){
                    if(hashMap.containsKey(data.getStopName())){
                        data.setStopId(hashMap.get(data.getStopName()));
                    }else{
                        order +=1;
                        hashMap.put(data.getStopName(),order);
                        data.setStopId(order);
                    }
                }
//                System.out.println(count);
//                System.out.println(stringBuilder);
                // 写法2
                String saveFileName = "E:\\IDEA\\alltest\\exceltest\\StopId生成(处理完).xlsx";
                // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
                // 如果这里想使用03 则 传入excelType参数即可
                EasyExcel.write(saveFileName, StopIdVO.class).sheet("sheet1").doWrite(cachedDataList);
            }
        }).sheet().doRead();
    }

    @Test
    void getTrainCode(){
        String fileName = "E:\\IDEA\\alltest\\exceltest\\trainCode.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, OrderToTrain.class, new ReadListener<OrderToTrain>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 800;
            /**
             *临时存储
             */
            private List<OrderToTrain> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(OrderToTrain data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            //解析完后做什么
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                int muban = 3300100;
                for (OrderToTrain data :cachedDataList){
                    if(data.getOrder().equals(1)){
                        muban += 1;
                        data.setTrain(muban);
                    }else{
                        data.setTrain(muban);
                    }

                }
//                System.out.println(count);
//                System.out.println(stringBuilder);
                // 写法2
                String saveFileName = "E:\\IDEA\\alltest\\exceltest\\trainCode(处理完).xlsx";
                // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
                // 如果这里想使用03 则 传入excelType参数即可
                EasyExcel.write(saveFileName, OrderToTrain.class).sheet("sheet1").doWrite(cachedDataList);
            }
        }).sheet().doRead();
    }

    @Test
    void PhoneToMi(){
        String fileName = "E:\\IDEA\\alltest\\exceltest\\APP20221011.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, PhoneAndMi.class, new ReadListener<PhoneAndMi>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 400;
            /**
             *临时存储
             */
            private List<PhoneAndMi> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(PhoneAndMi data, AnalysisContext context) {
                String phone = data.getPhone();
                data.setPwd(phone);
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            //解析完后做什么
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                List<PhoneAndMi> cachedDataList2 = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                System.out.println(cachedDataList.size());
                StringBuilder stringBuilder = new StringBuilder();
                int count = 0;
                for (PhoneAndMi data :cachedDataList){
                    /*if(!data.getUserId().equals("未注册")) {
                        stringBuilder.append( data.getPhone() + ",");
                        count++;
                    }*/
                    if(data.getUserId().equals("未注册")) {
                        cachedDataList2.add(data);
                    }
                }
//                System.out.println(count);
//                System.out.println(stringBuilder);
                // 写法2
                String saveFileName = "E:\\IDEA\\alltest\\exceltest\\APP20221011(未注册清单).xlsx";
                // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
                // 如果这里想使用03 则 传入excelType参数即可
                EasyExcel.write(saveFileName, PhoneAndMi.class).sheet("sheet1").doWrite(cachedDataList2);
            }
        }).sheet().doRead();
    }

    @Test
    void EasyExcelReadTest(){
        String fileName = "E:\\IDEA\\alltest\\demoTest.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new ReadListener<DemoData>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 500;
            /**
             *临时存储
             */
            private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            //解析完后做什么
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info(cachedDataList.size() + "条数据，开始存储数据库！");
                ArrayList<Object[]> objectList = new ArrayList<>();
                for (DemoData demoData : cachedDataList) {
                    Object[] objects = new Object[]{demoData.getString(),demoData.getDate(),demoData.getDoubleData()};
                    objectList.add(objects);
                }
                String isnertSql = "insert into excel_test(string,day,number) values(?,?,?)";
                int[] ints = jdbcTemplate.batchUpdate(isnertSql, objectList);
                int actualValue = ints.length;
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();
    }

    public  List<DemoData> data(){
        List<DemoData> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new DemoData("lalalawuwuwu"+i,new Date(),(double) i+50,null));
        }
        return data;
    }

    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "E:\\IDEA\\alltest\\demoTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
/*        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });*/

        // 写法2
        fileName = "E:\\IDEA\\alltest\\demoTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

/*        // 写法3
        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        }*/
    }
}
