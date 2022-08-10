package com.water.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.water.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}