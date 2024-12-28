package com.nx.nxrpc.server;

import com.nx.nxrpc.model.RpcRequest;
import com.nx.nxrpc.model.RpcResponse;
import com.nx.nxrpc.registry.LocalRegistry;
import com.nx.nxrpc.serializer.JdkSerializer;
import com.nx.nxrpc.serializer.Serializer;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * HTTP 请求处理
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class HttpServerHandler implements Handler<HttpServerRequest> {
    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        //指定序列化器
        final Serializer serializer = new JdkSerializer();

        //记录日志
        System.out.println("Receive request: " + httpServerRequest.method() + " " + httpServerRequest.uri());

        //异步处理 HTTP 请求
        httpServerRequest.bodyHandler(body -> {
            byte[] bytes = body.getBytes();
            RpcRequest rpcRequest = null;
            try {
                rpcRequest = serializer.deserialize(bytes, RpcRequest.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //构造响应结果对象
            RpcResponse rpcResponse = new RpcResponse();
            if (rpcRequest == null) {
                rpcResponse.setMessage("RpcRequest is null");
                doResponse(httpServerRequest, serializer, rpcResponse);
                return;
            }
            try {
                //获取要调用的服务实现类，通过反射进行调用
                Class<?> implClass = LocalRegistry.get(rpcRequest.getServiceName());
                Method method = implClass.getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
                Object result = method.invoke(implClass.newInstance(), rpcRequest.getArgs());
                //封装返回结果
                rpcResponse.setData(result);
                rpcResponse.setDataType(method.getReturnType());
                rpcResponse.setMessage("ok");
            } catch (Exception e) {
                e.printStackTrace();
                rpcResponse.setMessage(e.getMessage());
                rpcResponse.setException(e);
            }
            //响应
            doResponse(httpServerRequest, serializer, rpcResponse);
        });

    }

    /**
     * do response
     *
     * @param httpServerRequest http server request
     * @param serializer        serializer
     * @param rpcResponse       rpc response
     */
    void doResponse(HttpServerRequest httpServerRequest, Serializer serializer, RpcResponse rpcResponse) {
        HttpServerResponse httpServerResponse = httpServerRequest.response().putHeader("content-type", "application" +
                "/json");
        //序列化
        try {
            byte[] serialized = serializer.serialize(rpcResponse);
            httpServerResponse.end(Buffer.buffer(serialized));
        } catch (IOException e) {
            e.printStackTrace();
            httpServerResponse.end(Buffer.buffer());
        }
    }
}
