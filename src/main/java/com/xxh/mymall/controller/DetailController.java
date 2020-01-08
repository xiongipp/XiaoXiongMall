package com.xxh.mymall.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.xxh.mymall.entity.Goods;
import com.xxh.mymall.entity.User;
import com.xxh.mymall.service.GoodsService;
import com.xxh.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.Serializable;

@Controller
public class DetailController extends ApiController {
    @Resource
    private GoodsService goodsService;

    @Resource
    private UserService userService;
    @GetMapping("/details")
    public String toGoodsDetail(int id,Model model)
    {
        Goods good = goodsService.getById(id);
        model.addAttribute("Good",good);
        return "detail";
    }
}
