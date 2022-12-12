package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineSaveVO {

    @ExcelProperty("线路id")
    private Integer lineId;
    @ExcelProperty("线路名称")
    private String lineName;
    @ExcelProperty("线路名称颜色")
    private String lineColor;
    @ExcelProperty("线路id")
    private Integer stopId;
    @ExcelProperty("站点名称")
    private String stopName;

}
