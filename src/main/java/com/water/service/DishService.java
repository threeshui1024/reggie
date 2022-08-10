package com.water.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.water.dto.DishDto;
import com.water.entity.Dish;

public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    void updateWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);
}
