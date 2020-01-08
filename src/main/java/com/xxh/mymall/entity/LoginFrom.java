package com.xxh.mymall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LoginFrom {
    String username;
    String password;
    String radio;
}
