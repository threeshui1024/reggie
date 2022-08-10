package com.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.ShoppingCart;
import com.water.mapper.ShoppingCartMapper;
import com.water.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
