package com.xxh.mymall.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.mymall.Msg.ReturnMsg;
import com.xxh.mymall.entity.Goods;
import com.xxh.mymall.entity.OderListEx;
import com.xxh.mymall.entity.Orderlist;
import com.xxh.mymall.entity.User;
import com.xxh.mymall.service.GoodsService;
import com.xxh.mymall.service.OrderlistService;
import com.xxh.mymall.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2019-12-11 20:24:21
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private OrderlistService orderlistService;

    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }

    @PostMapping("/register")
    public ReturnMsg Register(@RequestBody User user) {
        ReturnMsg returnMsg = new ReturnMsg();
        QueryWrapper<User>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User dbuser = userService.getOne(queryWrapper);
        if(dbuser!=null){
            returnMsg.setState(100);
            returnMsg.setMsg("用户已经存在,换一个吧");
            return  returnMsg;
        }else {
            userService.save(user);
            returnMsg.setState(200);
            returnMsg.setMsg("注册成功");
            return  returnMsg;
        }
    }
    @GetMapping("/login")
    public ReturnMsg UserLogin(String username, String psw, HttpServletRequest request, HttpServletResponse response){
        ReturnMsg returnMsg = new ReturnMsg();
        QueryWrapper<User>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User dbuser = userService.getOne(queryWrapper);
        if(dbuser==null){
            returnMsg.setState(100);
            returnMsg.setMsg("用户不存在");
            return returnMsg;
        }else {
            if(!dbuser.getPassword().equals(psw)){
                returnMsg.setState(100);
                returnMsg.setMsg("密码错误");
                return returnMsg;
            }else {
                returnMsg.setState(200);
                returnMsg.setUserId(dbuser.getId());
                returnMsg.setMsg("登录成功");
                response.addCookie(new Cookie("userId", dbuser.getId().toString()));
                return  returnMsg;
            }
        }
    }

    @GetMapping("/logout")
    public ReturnMsg UserLogout(HttpServletResponse response,HttpServletRequest request){
        ReturnMsg returnMsg = new ReturnMsg();
        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("userId",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        returnMsg.setMsg("退出成功");
        return returnMsg;
    }


}