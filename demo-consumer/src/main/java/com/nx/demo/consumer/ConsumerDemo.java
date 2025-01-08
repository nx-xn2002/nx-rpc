package com.nx.demo.consumer;

import com.nx.demo.common.model.User;
import com.nx.demo.common.service.UserService;
import com.nx.nxrpc.config.RpcConfig;
import com.nx.nxrpc.constant.RpcConstant;
import com.nx.nxrpc.proxy.ServiceProxyFactory;
import com.nx.nxrpc.utils.ConfigUtils;

/**
 * 服务消费者示例
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        System.out.println(rpcConfig);

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

        //测试 mock
        long number = userService.genNumber();
        System.out.println(number);
    }
}

