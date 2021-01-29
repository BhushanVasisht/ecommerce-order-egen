package com.egen.orderproc.model;

import java.io.Serializable;

public class ItemSetId implements Serializable {
    private final String order_id;
    private final String order_item_name;

    public ItemSetId() {
        this("", "");
    }

    public ItemSetId(String order_id, String order_item_name) {
        this.order_id = order_id;
        this.order_item_name = order_item_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
