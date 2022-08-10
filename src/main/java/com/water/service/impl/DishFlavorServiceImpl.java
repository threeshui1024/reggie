package com.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.DishFlavor;
import com.water.mapper.DishFlavorMapper;
import com.water.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
