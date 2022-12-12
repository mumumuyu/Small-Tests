package com.lgd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Description:
 * @author: LGD
 * @date:2022/11/10 15:41
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestVOTest {

    private List<RequestVOTest2> requestVOTest2List;

}
