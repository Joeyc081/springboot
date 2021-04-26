package cn.soft.market_management.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -6592509956516090850L;
    private int state=1;//1代表成功，0代表失败
    private String message="OK";
    private Object data;
    public JsonResult(){

    }

    public JsonResult(String message){
        this.state=0;
        this.message=message;

    }

    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }

    public JsonResult(Object data){
        this.data=data;
    }
}
