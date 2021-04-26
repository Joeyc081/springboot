package cn.soft.market_management.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Depot implements Serializable {
    private static final long serialVersionUID = 847170878462079995L;

    private Integer id;
    private String pname;
    private int amount;
    private String unit;
}
