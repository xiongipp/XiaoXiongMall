package com.xxh.mymall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.mymall.dao.SellerDao;
import com.xxh.mymall.entity.Seller;
import com.xxh.mymall.service.SellerService;
import org.springframework.stereotype.Service;

/**
 * (Seller)表服务实现类
 *
 * @author makejava
 * @since 2019-12-25 15:31:38
 */
@Service("sellerService")
public class SellerServiceImpl extends ServiceImpl<SellerDao, Seller> implements SellerService {

}