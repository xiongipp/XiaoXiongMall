package com.xxh.mymall.controller;

import com.xxh.mymall.entity.Goods;
import com.xxh.mymall.entity.Orderlist;
import com.xxh.mymall.entity.User;
import com.xxh.mymall.service.GoodsService;
import com.xxh.mymall.service.OrderlistService;
import com.xxh.mymall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.Date;


@Controller
public class payController {
    @Resource
    UserService userService;

    @Resource
    GoodsService goodsService;

    @Resource
    OrderlistService orderlistService;
    @GetMapping("/pay")
    public  String payMoney(int userId, int gid,int num, Model model){
        User user = userService.getById(userId);
        Goods good = goodsService.getById(gid);
        Orderlist orderlist=new Orderlist();
        orderlist.setUserid(userId);
        orderlist.setGoodid(gid);
        orderlist.setBuynum(num);
        orderlist.setBuytime(new Date());
        orderlist.setPaymoney((double) (good.getGprice()*num));
        //生成一条订单数据
        orderlistService.save(orderlist);
        model.addAttribute("user",user);
        model.addAttribute("good",good);
        model.addAttribute("order",orderlist);
        return "PayMoney";
    }

}
