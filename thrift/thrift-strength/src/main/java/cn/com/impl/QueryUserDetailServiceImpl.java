package cn.com.impl;

import cn.com.Business.BusinessService;
import cn.com.exception.BizException;
import cn.com.pojo.UserPojo;
import net.sf.json.JSONObject;

/**
 * Created by xiaxuan on 16/9/5.
 * 查询用户详细信息的服务
 */
public class QueryUserDetailServiceImpl implements BusinessService<UserPojo> {

    @Override
    public UserPojo handle(JSONObject params) throws BizException {
        UserPojo userPojo = new UserPojo();
        userPojo.setUserAddr("用户地址");
        userPojo.setUserName("用户姓名");
        userPojo.setUserSex(1);
        return userPojo;
    }
}
