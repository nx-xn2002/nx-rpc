package com.nx.demo.provider;

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
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8888);
    }
}
