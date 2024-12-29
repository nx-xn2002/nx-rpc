package com.nx.demo.consumer;

import com.nx.demo.common.model.User;
import com.nx.demo.common.service.UserService;
import com.nx.nxrpc.proxy.ServiceProxyFactory;

/**
 * 服务消费者示例
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("nx");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}

