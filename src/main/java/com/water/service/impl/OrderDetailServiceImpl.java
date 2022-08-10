package com.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.OrderDetail;
import com.water.mapper.OrderDetailMapper;
import com.water.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}