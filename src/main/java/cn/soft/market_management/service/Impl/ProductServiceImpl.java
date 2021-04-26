package cn.soft.market_management.service.Impl;

import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.common.ServiceException;
import cn.soft.market_management.common.annotation.RequiredLog;
import cn.soft.market_management.dao.ProductDao;
import cn.soft.market_management.entity.Product;
import cn.soft.market_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    public int saveProduct(Product product) {
        int count= productDao.saveProduct(product);

        if (!(count>0))
            throw new ServiceException("插入失败");
        return count;
    }

    @RequiredLog("分页查询操作")
    public PageObject<Product> findPageObjects(String pname, Integer pageCurrent) throws IllegalAccessException {
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalAccessException("当前页码不正确");

        //基于条件 进行总记录查询
        int rowCount =productDao.getRowCount(pname);
        if (rowCount==0)
            throw new SecurityException("系统没有查到对应记录");
        int pageSize=10;
        int startIndex=(pageCurrent-1)*pageSize;
        //执行查询当前页操作
        List<Product> records=productDao.findPageObjects(pname,startIndex,pageSize);
        PageObject<Product> pageObject=new PageObject<>(pageCurrent,pageSize,rowCount,records);
        return pageObject;

    }

    @RequiredLog("删除操作")
    public int deleteObjects(Integer... ids) throws IllegalAccessException {
        if (ids==null||ids.length==0)
            throw new IllegalAccessException("请选择一个");
        //执行删除操作
        int row;
        try{
            row=productDao.deleteObjects(ids);

        }catch (Throwable e){
            throw new ServiceException("系统故障，正在恢复中...");
        }
        //验证返回结果
        if (row==0)
            throw new ServiceException("记录可能已经不存在");
        //返回结果
        return row;
    }
}
