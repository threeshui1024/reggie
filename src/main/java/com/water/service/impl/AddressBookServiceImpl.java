package com.water.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.water.entity.AddressBook;
import com.water.mapper.AddressBookMapper;
import com.water.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
