package cn.soft.market_management.Controller;


import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.entity.Provider;
import cn.soft.market_management.entity.Sell;
import cn.soft.market_management.service.ProviderService;
import cn.soft.market_management.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MallController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("starter")
    public String starter(){
        return "starter";
    }

    @RequestMapping("registry")
    public String registry(){
        return "registry";
    }






    @RequestMapping("{module}/{moduleUI}")
    public String doPageUI(@PathVariable String module,
                           @PathVariable String moduleUI){
        return module+"/"+moduleUI;
    }
    }


