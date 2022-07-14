package com.example.dictsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ZiPre {
    private Integer ID;
    private String zi;
    private String weizhi;
}
