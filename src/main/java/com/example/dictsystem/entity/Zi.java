package com.example.dictsystem.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Zi {
    private Integer ID;
    private String zi;
    private String weizhi;
    private String shuowen;
    private String yin;
    private String yi;
    private String wending;
    private String yinding;
    private String yiding;
    private byte[] zixing;
}
