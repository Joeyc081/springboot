package cn.soft.market_management.Controller;


import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Provider;
import cn.soft.market_management.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    ProviderService providerService;
    @RequestMapping("/doSaveProvider")
    public JsonResult doSaveProvider(Provider provider) {
        providerService.saveProvider(provider);
        return new JsonResult();
    }
    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String proname,Integer pageCurrent) throws IllegalAccessException {
        PageObject<Provider> pageObject=providerService.findPageObjects(proname, pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("/doDeleteObjects")
    public JsonResult doDeleteObjects(Integer...ids) throws IllegalAccessException {
        providerService.deleteObjects(ids);
        return new JsonResult();
    }

}
