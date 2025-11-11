package com.youngheart.youngaicodegenerate.model.dto.user;

import lombok.Data;

import java.io.Serializable;
/**
 * 用户注册请求体
 *
 * @author <a href="https://blog.csdn.net/weixin_73847538?spm=1000.2115.3001.5343">youngheart</a>
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;
}
