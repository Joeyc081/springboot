package cn.soft.market_management.Controller;


import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Sell;
import cn.soft.market_management.entity.SysUser;
import cn.soft.market_management.service.SellService;
import cn.soft.market_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //localhost:8081/user/doFindPageObjects?pageCurrent=1
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,Integer pageCurrent) throws IllegalAccessException {
        PageObject<SysUser> pageObject=userService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObject);
    }

    @RequestMapping("/doLogin")
    public JsonResult doLogin(String username, String password){
        if (userService.doLogin(username,password)){
            return new JsonResult();
        }
        return new JsonResult("登录失败");
    }

    @RequestMapping("/doReg")
    public JsonResult doReg(SysUser sysUser){
        int count=userService.reg(sysUser);
        return new JsonResult();
    }





}
