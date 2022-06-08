package com.simon.scaffold.user.business.api;

import java.io.Serializable;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/6/8 15:49
 * @description: api 地址
 */
public class SimonUserSrvApi implements Serializable {
    private static final long serialVersionUID = 6179971423236864891L;

    public static final String USER_DETAIL = "simon.user.srv.api.user.detail";
    public static final String USER_ACCOUNT = "simon.user.srv.api.user.account";

    /**
     * @description: 按模块区分api
     */
    public static class Role implements Serializable {
        private static final long serialVersionUID = 3656442675784655685L;
        public static final String ROLE_LIST = "simon.user.srv.api.user.role.list";
    }
}
