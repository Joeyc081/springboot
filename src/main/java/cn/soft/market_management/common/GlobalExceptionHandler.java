package cn.soft.market_management.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandlerRuntimeException(RuntimeException e){
        System.out.println("进入了异常处理方法");
        e.printStackTrace();//将异常信息打印到控制台
        return new JsonResult(e);
    }

}
