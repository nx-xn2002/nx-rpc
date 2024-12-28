package com.nx.demo.common.model;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
