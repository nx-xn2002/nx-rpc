package com.nx.nxrpc.server;

/**
 * HTTP 服务器接口
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public interface HttpServer {
    /**
     * 启动服务器
     *
     * @param port 端口号
     * @author nx-xn2002
     */
    void doStart(int port);
}
