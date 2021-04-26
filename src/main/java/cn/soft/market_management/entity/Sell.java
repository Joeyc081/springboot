package cn.soft.market_management.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Sell implements Serializable {
    private static final long serialVersionUID = 7247055304797026666L;
    private Integer id;
    private String pname;
    private String sellprice;
    private int amount;
    private Date time;
    private String address;

}
