package com.nx.nxrpc.proxy;

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
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }
}
