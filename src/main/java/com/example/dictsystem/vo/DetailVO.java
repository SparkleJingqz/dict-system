package com.example.dictsystem.vo;

import com.example.dictsystem.entity.Xing;
import com.example.dictsystem.entity.Zi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetailVO {
    private Zi zi;
    private Integer count;
    private List<Xing> xings;
}
