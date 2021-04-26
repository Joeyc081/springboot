package cn.soft.market_management.Controller;

import cn.soft.market_management.common.JsonResult;
import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.entity.Product;
import cn.soft.market_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/doSaveProduct")
    public JsonResult doSaveProduct(Product product) {
        productService.saveProduct(product);
        return new JsonResult();
    }
    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(String pname,Integer pageCurrent) throws IllegalAccessException {
        PageObject<Product> pageObject=productService.findPageObjects(pname, pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("/doDeleteObjects")
    public JsonResult doDeleteObjects(Integer...ids) throws IllegalAccessException {
        productService.deleteObjects(ids);
        return new JsonResult();
    }
}
