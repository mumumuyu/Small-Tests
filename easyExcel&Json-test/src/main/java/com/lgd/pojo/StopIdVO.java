package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/19 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopIdVO {

    @ExcelProperty("stopName")
    private String stopName;
    @ExcelProperty("stopId")
    private Integer stopId;

}
