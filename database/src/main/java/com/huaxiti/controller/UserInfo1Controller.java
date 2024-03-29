package com.huaxiti.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huaxiti.entity.UserInfo;
import com.huaxiti.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (UserInfo)表控制层
 *
 * @author makejava
 * @since 2023-07-03 23:03:30
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param userInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UserInfo> page, UserInfo userInfo) {
        return success(this.userInfoService.page(page, new QueryWrapper<>(userInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UserInfo userInfo) {
        return success(this.userInfoService.save(userInfo));
    }

    /**
     * 修改数据
     *
     * @param userInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UserInfo userInfo) {
        return success(this.userInfoService.updateById(userInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userInfoService.removeByIds(idList));
    }
}

