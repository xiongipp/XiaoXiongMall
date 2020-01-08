package com.xxh.mymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Type)表实体类
 *
 * @author makejava
 * @since 2019-12-04 10:23:28
 */
@SuppressWarnings("serial")
public class Type extends Model<Type> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String tname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
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