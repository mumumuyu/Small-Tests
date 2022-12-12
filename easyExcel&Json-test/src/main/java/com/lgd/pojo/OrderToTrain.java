package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/18 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderToTrain {

    @ExcelProperty("order")
    private Integer order;

    @ExcelProperty("train")
    private Integer train;

}
