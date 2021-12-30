package com.drive.GoogleDriveProject.ORM.data;

public class TacoOrder {
    private Integer oderId;
    private String tacoName;
    private Double tacoPrice;
    private Integer count;
    public Integer getOderId() {
        return oderId;
    }

    public void setOderId(Integer oderId) {
        this.oderId = oderId;
    }

    public String getTacoName() {
        return tacoName;
    }

    public void setTacoName(String tacoName) {
        this.tacoName = tacoName;
    }

    public Double getTacoPrice() {
        return tacoPrice;
    }

    public void setTacoPrice(Double tacoPrice) {
        this.tacoPrice = tacoPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


}
