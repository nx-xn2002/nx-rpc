package com.nx.nxrpc.serializer;

import java.io.*;

/**
 * JDK 序列化器
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class JdkSerializer implements Serializer {
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            Object object = objectInputStream.readObject();
            return castObject(object, clazz);
        } catch (ClassNotFoundException e) {
            throw new IOException("Deserialization failed due to class not found", e);
        }
    }

    private <T> T castObject(Object object, Class<T> clazz) throws IOException {
        if (clazz.isInstance(object)) {
            return clazz.cast(object);
        } else {
            throw new IOException("Object of type " + object.getClass().getName() +
                    " cannot be cast to " + clazz.getName());
        }
    }
}
