package com.xxh.mymall.Msg;

import lombok.Data;

@Data
public class ReturnMsg {
    int state;
    String msg;
    int adminId;
    int userId;
    int sellerId;

}
