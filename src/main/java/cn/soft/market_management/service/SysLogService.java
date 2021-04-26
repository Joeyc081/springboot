package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.SysLog;

public interface SysLogService {

    PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) throws IllegalAccessException;

    int deleteObjects(Integer...ids) throws IllegalAccessException;

    void saveObject(SysLog sysLog);

}
