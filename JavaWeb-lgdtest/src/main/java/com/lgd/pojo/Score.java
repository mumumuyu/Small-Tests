package com.lgd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private String id;
    private String name;
    private String type;
    private String scorenum;

    public static boolean isEmpty(String ...strings) {
        for (String str:strings){
            if (str == null || str.trim().length() == 0) {
                return true;
            }
        }
        return false;
    }
}
