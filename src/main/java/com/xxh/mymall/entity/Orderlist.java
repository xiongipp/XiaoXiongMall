package com.xxh.mymall.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Orderlist)表实体类
 *
 * @author makejava
 * @since 2019-12-25 19:26:40
 */
@SuppressWarnings("serial")
public class Orderlist extends Model<Orderlist> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer userid;
    
    private Integer goodid;
    
    private Integer buynum;
    
    private Double paymoney;
    
    private Date buytime;
    
    private String isdelivered;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public String getIsdelivered() {
        return isdelivered;
    }

    public void setIsdelivered(String isdelivered) {
        this.isdelivered = isdelivered;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }