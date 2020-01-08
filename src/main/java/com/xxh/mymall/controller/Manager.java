package com.xxh.mymall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxh.mymall.entity.Admin;
import com.xxh.mymall.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class Manager {

    @Resource
    private AdminService adminService;

    @GetMapping("/Manager")
    public  String toManagerPage(@RequestParam("id") int id, Model model){
        QueryWrapper<Admin> wr=new QueryWrapper<>();
        wr.eq("id",id);
        Admin admin = adminService.getOne(wr);
        if(admin!=null){
            model.addAttribute("adminId",id);
            return "Manager";
        }else {
            return null;
        }
    }
}
