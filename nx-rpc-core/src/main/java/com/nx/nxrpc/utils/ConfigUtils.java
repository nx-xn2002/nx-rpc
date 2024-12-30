package com.nx.nxrpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 配置工具类
 *
 * @author nx-xn2002
 * @date 2024-12-30
 */
public class ConfigUtils {
    /**
     * 加载配置对象
     *
     * @param tClass t class
     * @param prefix prefix
     * @return {@link T }
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象，支持区分环境
     *
     * @param tClass t class
     * @param prefix prefix
     * @param env    env
     * @return {@link T }
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String env) {
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(env)) {
            configFileBuilder.append("-").append(env);
        }
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());
        return props.toBean(tClass, prefix);
    }
}
