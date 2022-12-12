package com.lgd.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: LGD
 * @date:2022/10/11 17:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneAndMi {

    @ExcelProperty("序号")
    private Integer id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("加密后")
    private String pwd;

    @ExcelProperty("id")
    private String userId;
}
