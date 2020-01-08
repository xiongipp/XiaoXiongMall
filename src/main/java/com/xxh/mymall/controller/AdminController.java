package com.xxh.mymall.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.mymall.Msg.ReturnMsg;
import com.xxh.mymall.entity.Admin;
import com.xxh.mymall.entity.LoginFrom;
import com.xxh.mymall.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2019-12-04 17:38:32
 */
@RestController
@RequestMapping("admin")
public class AdminController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param admin 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Admin> page, Admin admin) {
        return success(this.adminService.page(page, new QueryWrapper<>(admin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.adminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Admin admin) {
        return success(this.adminService.save(admin));
    }

    /**
     * 修改数据
     *
     * @param admin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Admin admin) {
        return success(this.adminService.updateById(admin));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.adminService.removeByIds(idList));
    }
    @GetMapping("/login")
    public ReturnMsg ConfigUser(String username, String password, HttpSession session){

        ReturnMsg msg = new ReturnMsg();
            QueryWrapper<Admin> wr=new QueryWrapper<>();
            wr.eq("adname",username);
            Admin ad = adminService.getOne(wr);
            if(ad==null){
                msg.setState(100);
                msg.setMsg("该用户不存在");
            }else {
                if(!ad.getPassword().equals(password)){
                    msg.setState(100);
                    msg.setMsg("密码错误");
                }else {
                    msg.setState(200);
                    msg.setAdminId(ad.getId());
                    msg.setMsg("登录成功");
                    session.setAttribute("loginAdmin",ad);//将管理员对象放入session中，准备拦截器
                }
            }
        return msg;
        }




}