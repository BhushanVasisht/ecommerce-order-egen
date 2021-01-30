package com.egen.orderproc.model;

import java.util.Arrays;

public class BatchOrder {

    BareOrder[] batch_orders;

    public BatchOrder() {

    }

    public BatchOrder(BareOrder[] batch_orders) {
        this.batch_orders = batch_orders;
    }

    public BareOrder[] getBatch_orders() {
        return batch_orders;
    }

    public void setBatch_orders(BareOrder[] batch_orders) {
        this.batch_orders = batch_orders;
    }

    @Override
    public String toString() {
        return "BatchOrder{" +
                "batch_orders=" + Arrays.toString(batch_orders) +
                '}';
    }
}
