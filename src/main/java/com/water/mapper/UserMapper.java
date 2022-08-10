package com.water.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.water.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
