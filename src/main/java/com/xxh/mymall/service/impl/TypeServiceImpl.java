package com.xxh.mymall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.mymall.dao.TypeDao;
import com.xxh.mymall.entity.Type;
import com.xxh.mymall.service.TypeService;
import org.springframework.stereotype.Service;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2019-12-04 10:23:28
 */
@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeDao, Type> implements TypeService {

}