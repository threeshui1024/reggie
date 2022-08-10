package com.water.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.water.dto.SetmealDto;
import com.water.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时删除套餐和菜品的关联数据
     * @param ids
     */
    void removeWithDish(List<Long> ids);

    /**
     * 根据id查询套餐信息和对应的菜品信息
     * @param id
     * @return
     */
    SetmealDto getByIdWithDish(Long id);

    /**
     * 修改套餐
     * @param setmealDto
     */
    void updateWithDish(SetmealDto setmealDto);
}
