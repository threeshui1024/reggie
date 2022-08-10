package com.water.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.Employee;
import com.water.mapper.EmployeeMapper;
import com.water.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
