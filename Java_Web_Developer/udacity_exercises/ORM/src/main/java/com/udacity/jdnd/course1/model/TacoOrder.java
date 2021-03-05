package com.udacity.jdnd.course1.model;

public class TacoOrder {
    int order_id;
    int taco_name;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getTaco_name() {
        return taco_name;
    }

    public void setTaco_name(int taco_name) {
        this.taco_name = taco_name;
    }

    public int getTaco_price() {
        return taco_price;
    }

    public void setTaco_price(int taco_price) {
        this.taco_price = taco_price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int taco_price;
    int count;
}
