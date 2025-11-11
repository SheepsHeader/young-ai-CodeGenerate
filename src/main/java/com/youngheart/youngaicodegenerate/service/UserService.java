package com.youngheart.youngaicodegenerate.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.youngheart.youngaicodegenerate.model.dto.user.UserQueryRequest;
import com.youngheart.youngaicodegenerate.model.entity.User;
import com.youngheart.youngaicodegenerate.model.vo.LoginUserVO;
import com.youngheart.youngaicodegenerate.model.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户 服务层。
 *
 * @author <a href="https://blog.csdn.net/weixin_73847538?spm=1000.2115.3001.5343">youngheart</a>
 */
public interface UserService extends IService<User> {
     /**
      * 用户注册
      *
      * @param userAccount 账号
      * @param userPassword 密码
      * @param checkPassword 校验密码
      * @return 新用户 id
      */
    Long register(String userAccount, String userPassword,String checkPassword);

    String encryptPassword(String userPassword);

    LoginUserVO getLoginUserVO(User user);

    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);


    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);
}
