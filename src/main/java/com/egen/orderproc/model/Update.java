package com.egen.orderproc.model;

import java.util.Arrays;

public class Update {

    UpdateStat[] orders;

    public Update() {

    }

    public Update(UpdateStat[] orders) {
        this.orders = orders;
    }

    public UpdateStat[] getOrders() {
        return orders;
    }

    public void setOrders(UpdateStat[] orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Update{" +
                "orders=" + Arrays.toString(orders) +
                '}';
    }
}
