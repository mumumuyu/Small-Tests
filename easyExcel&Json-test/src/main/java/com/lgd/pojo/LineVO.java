package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 10:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineVO {

    @ExcelProperty("线路id")
    private Integer id;
    @ExcelProperty("线路名称")
    private String name;
    @ExcelProperty("线路名称颜色")
    private String linecolor;

    private List<StopVO> round;

}
