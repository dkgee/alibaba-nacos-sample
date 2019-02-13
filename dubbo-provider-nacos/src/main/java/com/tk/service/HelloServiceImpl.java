package com.tk.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Description：describe this class function
 * Author；JinHuatao
 * Date: 2019/2/13 16:47
 */
@Service
public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {
        return "hello," + name;
    }
}
