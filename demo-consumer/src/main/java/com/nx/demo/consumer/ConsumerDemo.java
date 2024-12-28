package com.nx.demo.consumer;

import com.nx.demo.common.model.User;
import com.nx.demo.common.service.UserService;

/**
 * 服务消费者示例
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现类对象
        UserService userService = null;
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

