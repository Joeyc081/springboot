package cn.soft.market_management.Controller;


import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Depot;
import cn.soft.market_management.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/depot")
public class DepotController {
    @Autowired
    DepotService depotService;
    @RequestMapping("/doSaveDepot")
    public JsonResult doSaveDepot(Depot depot) {
        depotService.saveDepot(depot);
        return new JsonResult();
    }
    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String pname,Integer pageCurrent) throws IllegalAccessException {
        PageObject<Depot> pageObject=depotService.findPageObjects(pname, pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("/doDeleteObjects")
    public JsonResult doDeleteObjects(Integer...ids) throws IllegalAccessException {
        depotService.deleteObjects(ids);
        return new JsonResult();
    }
    @RequestMapping("/getdata")
    @ResponseBody
    public List<Depot> showData(){
        List<Depot> provinceArrayList;
        provinceArrayList = depotService.selectAll();
        return provinceArrayList;
    }
    @RequestMapping("/")
    public String echarts(){
        return "echarts";
    }

}
