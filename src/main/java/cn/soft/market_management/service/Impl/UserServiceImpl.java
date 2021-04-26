package cn.soft.market_management.service.Impl;


import cn.soft.market_management.common.PageObject;
import cn.soft.market_management.common.ServiceException;
import cn.soft.market_management.dao.UserDao;
import cn.soft.market_management.entity.SysUser;
import cn.soft.market_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean doLogin(String username, String password) {
        if(StringUtils.isEmpty(username))
            throw new ServiceException("用户名不能为空");
        if(StringUtils.isEmpty(password))
            throw new ServiceException("密码不能为空");
        //调用dao层获取数据
        SysUser sysUser = userDao.findUserByUsername(username);
        System.out.println(sysUser);
        //验证返回结果
        if (sysUser==null)
            throw new ServiceException("用户名不存在");
        //验证密码是否存在
        if (password.equals(sysUser.getPassword())) {
            return true;
        }
        return false;
    }


    public int reg(SysUser sysUser){
        //验证参数
        if (StringUtils.isEmpty(sysUser))
            throw new ServiceException("请输入用户");
        if(StringUtils.isEmpty(sysUser.getUsername())||sysUser.getUsername()=="")
            throw new ServiceException("请输入用户名");
        if(StringUtils.isEmpty(sysUser.getPassword())||sysUser.getPassword()=="")
            throw new ServiceException("请输入密码");
        SysUser user=userDao.findUserByUsername(sysUser.getUsername());
        if(!StringUtils.isEmpty(user))
            throw new ServiceException("用户已存在");
        //插入用户
        int count=userDao.saveUser(sysUser);

        if (!(count>0))
            throw new ServiceException("插入失败");
        return count;
    }

    @Override
    public PageObject<SysUser> findPageObjects(String username, Integer pageCurrent) throws IllegalAccessException {
        if (pageCurrent==null||pageCurrent<1)
            throw new IllegalAccessException("当前页码不正确");

        //基于条件 进行总记录查询
        int rowCount =userDao.getRowCount(username);
        if (rowCount==0)
            throw new SecurityException("系统没有查到对应记录");
        int pageSize=10;
        int startIndex=(pageCurrent-1)*pageSize;
        //执行查询当前页操作
        List<SysUser> records=userDao.findPageObjects(username,startIndex,pageSize);
        PageObject<SysUser> pageObject=new PageObject<>(pageCurrent,pageSize,rowCount,records);
        return pageObject;

    }

}
