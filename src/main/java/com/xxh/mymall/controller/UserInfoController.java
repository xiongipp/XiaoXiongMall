package com.xxh.mymall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxh.mymall.entity.Goods;
import com.xxh.mymall.entity.OderListEx;
import com.xxh.mymall.entity.Orderlist;
import com.xxh.mymall.service.GoodsService;
import com.xxh.mymall.service.OrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserInfoController {

    @Resource
    private OrderlistService orderlistService;

    @Resource
    private GoodsService goodsService;
    @GetMapping("/orderInfo")
    public String getOrderInfo(int uid, Model model){
        QueryWrapper<Orderlist> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userId",uid);
        List<Orderlist> orderlist = orderlistService.list(queryWrapper);
        List<OderListEx>oderListExList=new ArrayList<>();
        for(Orderlist order:orderlist){
            Goods good = goodsService.getById(order.getGoodid());
            OderListEx orderex = new OderListEx();
            orderex.setGoodname(good.getGname());
            orderex.setGoodsrc(good.getPicSrc());
            orderex.setPaymoney(order.getPaymoney());
            orderex.setBuytime(order.getBuytime());
            orderex.setBuynum(order.getBuynum());
            oderListExList.add(orderex);
        }
        model.addAttribute("orderlist",oderListExList);
        return "UserInfo";
    }
}
