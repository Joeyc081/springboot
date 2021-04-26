package cn.soft.market_management.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private static final long serialVersionUID = -5328922643373257144L;

    private Integer id;
    private String pname;
    private String clas;
    public String sellprice;
}
