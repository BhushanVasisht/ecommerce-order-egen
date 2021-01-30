package com.egen.orderproc.model;

import javax.validation.constraints.NotNull;

public class Items {

    @NotNull
    private String order_item_name;

    @NotNull
    private int order_item_qty;

    public Items(){

    }

    public Items(String order_item_name, int order_item_qty) {
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public int getOrder_item_qty() {
        return order_item_qty;
    }

    public void setOrder_item_qty(int order_item_qty) {
        this.order_item_qty = order_item_qty;
    }

    @Override
    public String toString() {
        return "Items{" +
                "order_item_name='" + order_item_name + '\'' +
                ", order_item_qty=" + order_item_qty +
                '}';
    }
}
