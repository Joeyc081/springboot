package cn.soft.market_management.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Provider implements Serializable {

    private static final long serialVersionUID = 7004167745214655340L;
    private Integer id;
    private String proname;
    private String adr;
    private String tel;
    private String product;




}
