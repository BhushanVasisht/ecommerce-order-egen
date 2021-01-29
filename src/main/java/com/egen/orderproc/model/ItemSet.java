package com.egen.orderproc.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_itemset")
@IdClass(ItemSetId.class)
public class ItemSet {

    @Id
    private String order_id;

    @Id
    private String order_item_name;

    private int order_item_qty;

    public ItemSet() {
    }

    public ItemSet(String order_id, String order_item_name, int order_item_qty) {
        this.order_id = order_id;
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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
        return "ItemSet{" +
                "order_id=" + order_id +
                ", order_item_name='" + order_item_name + '\'' +
                ", order_item_qty=" + order_item_qty +
                '}';
    }
}
