package cn.soft.market_management.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = -4697308575606321990L;

    private Integer pageCurrent=1;

    private Integer pageSize=10;

    private Integer rowCount=0;

    private Integer pageCount=0;

    private List<T> records;


    public PageObject(){

    }
    public PageObject(Integer pageCurrent,Integer pageSize,Integer rowCount,List<T> records){
        this.pageCurrent=pageCurrent;
        this.pageSize=pageSize;
        this.rowCount=rowCount;
        this.records=records;
        this.pageCount=(rowCount-1)/pageSize+1;
    }
}
