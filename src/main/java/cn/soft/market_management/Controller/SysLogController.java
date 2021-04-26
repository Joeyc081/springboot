package cn.soft.market_management.Controller;

import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.SysLog;
import cn.soft.market_management.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;
    //localhost:8081/log/doFindPageObjects?pageCurrent=1
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent) throws IllegalAccessException {
        PageObject<SysLog> pageObject=sysLogService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("doDeleteObjects")
    //localhost:8081/log/doDeleteObjects?ids=28,29
    public JsonResult doDeleteObjects(Integer...ids) throws IllegalAccessException {
        sysLogService.deleteObjects(ids);
        return new JsonResult();
    }
}
