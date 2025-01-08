package com.nx.nxrpc.proxy;

import com.nx.nxrpc.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * 动态代理工厂(用于创建代理对象)
 *
 * @author nx-xn2002
 * @date 2024-12-29
 */
public class ServiceProxyFactory {
    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass service class
     * @return {@link T }
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        if (RpcApplication.getRpcConfig().isMock()) {
            return getMockProxy(serviceClass);
        }
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }

    /**
     * 根据服务类获取 Mock 代理对象
     *
     * @param serviceClass service class
     * @return {@link T }
     */
    public static <T> T getMockProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy()
        );
    }
}
