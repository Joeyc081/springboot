package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Sell;
import cn.soft.market_management.entity.SysUser;

public interface UserService {

    public boolean doLogin(String username,String password);
    public int reg(SysUser sysUser);

    PageObject<SysUser> findPageObjects(String username, Integer pageCurrent) throws IllegalAccessException;


}
