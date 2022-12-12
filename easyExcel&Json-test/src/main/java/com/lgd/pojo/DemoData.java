package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/11 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoData {
    @ExcelProperty("字符串")
    private String string;
    @ExcelProperty("日期")
    private Date date;
    @ExcelProperty("数字")
    private Double doubleData;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;


}
