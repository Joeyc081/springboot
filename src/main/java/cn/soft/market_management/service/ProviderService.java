package cn.soft.market_management.service;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Provider;

public interface ProviderService {

    int saveProvider(Provider provider);
    PageObject<Provider> findPageObjects(String proname, Integer pageCurrent) throws IllegalAccessException;
    int deleteObjects(Integer...ids) throws IllegalAccessException;
}
