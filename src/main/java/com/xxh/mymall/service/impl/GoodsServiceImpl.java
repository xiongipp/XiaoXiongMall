package com.xxh.mymall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.mymall.dao.GoodsDao;
import com.xxh.mymall.entity.Goods;
import com.xxh.mymall.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2019-12-18 11:36:27
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

}