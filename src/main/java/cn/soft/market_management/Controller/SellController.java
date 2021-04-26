package cn.soft.market_management.Controller;

import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Sell;
import cn.soft.market_management.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    SellService sellService;
    @RequestMapping("/doSaveSell")
    public JsonResult doSaveSell(Sell sell) {
        sellService.saveSell(sell);
        return new JsonResult();
    }
    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String pname,Integer pageCurrent) throws IllegalAccessException {
        PageObject<Sell> pageObject=sellService.findPageObjects(pname, pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("/doDeleteObjects")
    public JsonResult doDeleteObjects(Integer...ids) throws IllegalAccessException {
        sellService.deleteObjects(ids);
        return new JsonResult();
    }
}
