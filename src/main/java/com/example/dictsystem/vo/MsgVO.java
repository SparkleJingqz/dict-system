package com.example.dictsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MsgVO {
    private Integer code;
    private String msg;
    private Integer count;
    private String name;
}
