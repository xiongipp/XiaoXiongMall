package com.xxh.mymall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.mymall.dao.AdminDao;
import com.xxh.mymall.entity.Admin;
import com.xxh.mymall.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2019-12-04 17:38:32
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

}