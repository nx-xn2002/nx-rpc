package com.nx.nxrpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地注册中心
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class LocalRegistry {
    /**
     * 注册信息存储
     */
    private static final Map<String, Class<?>> REGISTRY = new ConcurrentHashMap<>();

    /**
     * 注册服务
     *
     * @param serviceName 服务名
     * @param implClass   服务实现类
     * @author nx-xn2002
     */
    public static void register(String serviceName, Class<?> implClass) {
        REGISTRY.put(serviceName, implClass);
    }

    /**
     * 获取服务
     *
     * @param serviceName 服务名
     * @return {@link Class }<{@link ? }>
     * @author nx-xn2002
     */
    public static Class<?> get(String serviceName) {
        return REGISTRY.get(serviceName);
    }

    /**
     * 删除服务
     *
     * @param serviceName 服务名
     * @author nx-xn2002
     */
    public static void remove(String serviceName) {
        REGISTRY.remove(serviceName);
    }
}

