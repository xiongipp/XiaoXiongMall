package com.xxh.mymall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OderListEx {
    private Integer id;
    private Integer userid;
    private Integer goodid;
    private Integer buynum;
    private Double paymoney;
    private Date buytime;
    private String goodsrc;
    private String goodname;
    private String state;
}
