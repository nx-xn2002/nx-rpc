package com.nx.nxrpc.config;

import lombok.Data;

/**
 * RPC 框架配置
 *
 * @author nx-xn2002
 * @date 2024-12-30
 */
@Data
public class RpcConfig {
    /**
     * 名称
     */
    private String name = "nx-rpc";
    /**
     * 版本号
     */
    private String version = "1.0";
    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";
    /**
     * 服务器端口号
     */
    private Integer serverPort = 8888;
}
