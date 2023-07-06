package com.huaxiti.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huaxiti.entity.UserLogin;
import com.huaxiti.service.UserLoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (UserLogin)表控制层
 *
 * @author makejava
 * @since 2023-07-05 10:37:33
 */
@RestController
@RequestMapping("userLogin")
public class UserLoginController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserLoginService userLoginService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param userLogin 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UserLogin> page, UserLogin userLogin) {
        return success(this.userLoginService.page(page, new QueryWrapper<>(userLogin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userLoginService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userLogin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UserLogin userLogin) {
        return success(this.userLoginService.save(userLogin));
    }

    /**
     * 修改数据
     *
     * @param userLogin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UserLogin userLogin) {
        return success(this.userLoginService.updateById(userLogin));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userLoginService.removeByIds(idList));
    }
}

