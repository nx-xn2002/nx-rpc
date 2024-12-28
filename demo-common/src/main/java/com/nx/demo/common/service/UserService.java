package com.nx.demo.common.service;

import com.nx.demo.common.model.User;

/**
 * 用户服务
 *
 * @author nx-xn2002
 * @date 2024-12-28
 */
public interface UserService {
    /**
     * 获取用户
     *
     * @param user user
     * @return {@link User }
     * @author nx-xn2002
     */
    User getUser(User user);
}
