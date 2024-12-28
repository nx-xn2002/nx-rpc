package com.nx.nxrpc.serializer;

import java.io.IOException;

/**
 * 序列化器接口
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public interface Serializer {
    /**
     * 序列化
     *
     * @param object 序列化对象
     * @return {@link byte[] }
     * @throws IOException IOException
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes 数据
     * @param clazz 类型
     * @return {@link T }
     * @throws IOException IOException
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException;
}
