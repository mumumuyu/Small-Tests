package com.lgd.pojo;

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
public class StopVO {

    private Integer id;

    private Integer lineId;

    private String name;

    private List<TurnLineVO> turnline;

}
