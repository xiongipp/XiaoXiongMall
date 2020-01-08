package com.xxh.mymall.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.mymall.entity.Type;
import com.xxh.mymall.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2019-12-04 10:23:28
 */
@RestController
@RequestMapping("type")
public class TypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param type 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Type> page, Type type) {
        return success(this.typeService.page(page, new QueryWrapper<>(type)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.typeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param type 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Type type) {
        return success(this.typeService.save(type));
    }

    /**
     * 修改数据
     *
     * @param type 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Type type) {
        return success(this.typeService.updateById(type));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.typeService.removeByIds(idList));
    }
}