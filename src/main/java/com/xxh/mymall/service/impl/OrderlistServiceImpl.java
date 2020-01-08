package com.xxh.mymall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.mymall.dao.OrderlistDao;
import com.xxh.mymall.entity.Orderlist;
import com.xxh.mymall.service.OrderlistService;
import org.springframework.stereotype.Service;

/**
 * (Orderlist)表服务实现类
 *
 * @author makejava
 * @since 2019-12-18 14:01:30
 */
@Service("orderlistService")
public class OrderlistServiceImpl extends ServiceImpl<OrderlistDao, Orderlist> implements OrderlistService {

}