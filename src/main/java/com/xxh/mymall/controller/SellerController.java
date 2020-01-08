package com.xxh.mymall.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.mymall.Msg.ReturnMsg;
import com.xxh.mymall.entity.*;
import com.xxh.mymall.service.GoodsService;
import com.xxh.mymall.service.OrderlistService;
import com.xxh.mymall.service.SellerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (Seller)表控制层
 *
 * @author makejava
 * @since 2019-12-25 15:31:38
 */
@RestController
@RequestMapping("seller")
public class SellerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SellerService sellerService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private OrderlistService orderlistService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param seller 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Seller> page, Seller seller) {
        return success(this.sellerService.page(page, new QueryWrapper<>(seller)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sellerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param seller 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Seller seller) {
        return success(this.sellerService.save(seller));
    }

    /**
     * 修改数据
     *
     * @param seller 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Seller seller) {
        return success(this.sellerService.updateById(seller));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sellerService.removeByIds(idList));
    }
    //受理卖家登录请求
    @GetMapping("/login")
    public ReturnMsg SellerLogin(String sellername, String psw){
        ReturnMsg returnMsg = new ReturnMsg();
        QueryWrapper<Seller>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sellername",sellername);
        Seller dbuser = sellerService.getOne(queryWrapper);
        if(dbuser==null){
            returnMsg.setState(100);
            returnMsg.setMsg("卖家不存在");
            return returnMsg;
        }else {
            if(!dbuser.getPassword().equals(psw)){
                returnMsg.setState(100);
                returnMsg.setMsg("密码错误");
                return returnMsg;
            }else {
                returnMsg.setState(200);
                returnMsg.setSellerId(dbuser.getId());
                returnMsg.setMsg("登录成功");
                return  returnMsg;
            }
        }

    }

    @GetMapping("/getOrder")
    public R getUserOrder(String sid){
        QueryWrapper<Goods>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sid",sid);
        List<Goods> goods = goodsService.list(queryWrapper);
        List<Orderlist>allList=new ArrayList<>();
        //得到卖家商品的所有的订单信息
        for(Goods good:goods){
            QueryWrapper<Orderlist> Wrapper = new QueryWrapper<>();
            Wrapper.eq("goodId",good.getId());
            List<Orderlist> orderlistList = orderlistService.list(Wrapper);
            for(Orderlist orderlist:orderlistList){
                allList.add(orderlist);
            }
        }
        //丰富订单信息，并返回前台
        List<OderListEx>listExes=new ArrayList<>();
        for (Orderlist orderlist:allList){
            Goods good = goodsService.getById(orderlist.getGoodid());
            OderListEx oderListEx=new OderListEx();
            oderListEx.setGoodsrc(good.getPicSrc());
            oderListEx.setGoodname(good.getGname());
            oderListEx.setBuynum(orderlist.getBuynum());
            oderListEx.setBuytime(orderlist.getBuytime());
            oderListEx.setPaymoney(orderlist.getPaymoney());
            oderListEx.setGoodid(orderlist.getGoodid());
            oderListEx.setUserid(orderlist.getUserid());
            oderListEx.setId(orderlist.getId());//记住返回的ID是订单列表的ID
            oderListEx.setState(orderlist.getIsdelivered());//商品状态，发货之类的。
            listExes.add(oderListEx);
        }
        return success(listExes);
    }


}