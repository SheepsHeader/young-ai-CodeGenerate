package com.youngheart.youngaicodegenerate.service;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.youngheart.youngaicodegenerate.model.dto.app.AppQueryRequest;
import com.youngheart.youngaicodegenerate.model.entity.App;
import com.youngheart.youngaicodegenerate.model.entity.User;
import com.youngheart.youngaicodegenerate.model.vo.AppVO;
import com.youngheart.youngaicodegenerate.model.vo.UserVO;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://blog.csdn.net/weixin_73847538?spm=1000.2115.3001.5343">youngheart</a>
 */
public interface AppService extends IService<App> {


    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);
}
