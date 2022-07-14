package com.example.dictsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ZiXing {
    private int ID;
    private String miaoshu;
    private byte[] zixing;
}
