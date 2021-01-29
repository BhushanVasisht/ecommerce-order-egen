package com.egen.orderproc.model;

import javax.persistence.Id;
import java.io.Serializable;

public class PaymentId implements Serializable {

    @Id
    private String order_payment_confirmation_number;

    @Id
    private String order_id;

    public String getOrder_payment_confirmation_number() {
        return order_payment_confirmation_number;
    }

    public void setOrder_payment_confirmation_number(String order_payment_confirmation_number) {
        this.order_payment_confirmation_number = order_payment_confirmation_number;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public PaymentId()
    {
        this("", "");
    }

    public PaymentId(String order_payment_confirmation_number, String order_id) {
        this.order_payment_confirmation_number = order_payment_confirmation_number;
        this.order_id = order_id;
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
