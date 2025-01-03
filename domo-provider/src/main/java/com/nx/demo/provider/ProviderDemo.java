package com.nx.demo.provider;

import com.nx.demo.common.service.UserService;
import com.nx.demo.provider.service.UserServiceImpl;
import com.nx.nxrpc.RpcApplication;
import com.nx.nxrpc.registry.LocalRegistry;
import com.nx.nxrpc.server.HttpServer;
import com.nx.nxrpc.server.VertxHttpServer;

/**
 * provider demo
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class ProviderDemo {
    public static void main(String[] args) {
        //初始化 RPC 服务
        RpcApplication.init();

        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
