package com.egen.orderproc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@IdClass(PaymentId.class)
@Table(name = "orders_payment")
public class Payment {

    @Id
    @NotNull
    private String order_payment_confirmation_number;

    @Id
    @NotNull
    private String order_id;

    @NotNull
    private String order_customer_id;

    @NotNull
    private String order_payment_method;

    @NotNull
    private Date order_payment_date;

    private String order_billing_addressline1;
    private String order_billing_addressline2 = "";
    private String order_billing_city;
    private String order_billing_state;
    private String order_billing_zip;


    public Payment() {

    }

    public Payment(String order_payment_confirmation_number, String order_id, String order_customer_id, String order_payment_method, Date order_payment_date, String order_billing_addressline1, String order_billing_addressline2, String order_billing_city, String order_billing_state, String order_billing_zip) {
        this.order_payment_confirmation_number = order_payment_confirmation_number;
        this.order_id = order_id;
        this.order_customer_id = order_customer_id;
        this.order_payment_method = order_payment_method;
        this.order_payment_date = order_payment_date;
        this.order_billing_addressline1 = order_billing_addressline1;
        this.order_billing_addressline2 = order_billing_addressline2;
        this.order_billing_city = order_billing_city;
        this.order_billing_state = order_billing_state;
        this.order_billing_zip = order_billing_zip;
    }

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

    public String getOrder_customer_id() {
        return order_customer_id;
    }

    public void setOrder_customer_id(String order_customer_id) {
        this.order_customer_id = order_customer_id;
    }

    public String getOrder_payment_method() {
        return order_payment_method;
    }

    public void setOrder_payment_method(String order_payment_method) {
        this.order_payment_method = order_payment_method;
    }

    public Date getOrder_payment_date() {
        return order_payment_date;
    }

    public void setOrder_payment_date(Date order_payment_date) {
        this.order_payment_date = order_payment_date;
    }

    public String getOrder_billing_addressline1() {
        return order_billing_addressline1;
    }

    public void setOrder_billing_addressline1(String order_billing_addressline1) {
        this.order_billing_addressline1 = order_billing_addressline1;
    }

    public String getOrder_billing_addressline2() {
        return order_billing_addressline2;
    }

    public void setOrder_billing_addressline2(String order_billing_addressline2) {
        this.order_billing_addressline2 = order_billing_addressline2;
    }

    public String getOrder_billing_city() {
        return order_billing_city;
    }

    public void setOrder_billing_city(String order_billing_city) {
        this.order_billing_city = order_billing_city;
    }

    public String getOrder_billing_state() {
        return order_billing_state;
    }

    public void setOrder_billing_state(String order_billing_state) {
        this.order_billing_state = order_billing_state;
    }

    public String getOrder_billing_zip() {
        return order_billing_zip;
    }

    public void setOrder_billing_zip(String order_billing_zip) {
        this.order_billing_zip = order_billing_zip;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "order_payment_confirmation_number='" + order_payment_confirmation_number + '\'' +
                ", order_id='" + order_id + '\'' +
                ", order_customer_id='" + order_customer_id + '\'' +
                ", order_payment_method='" + order_payment_method + '\'' +
                ", order_payment_date=" + order_payment_date +
                ", order_billing_addressline1='" + order_billing_addressline1 + '\'' +
                ", order_billing_addressline2='" + order_billing_addressline2 + '\'' +
                ", order_billing_city='" + order_billing_city + '\'' +
                ", order_billing_state='" + order_billing_state + '\'' +
                ", order_billing_zip='" + order_billing_zip + '\'' +
                '}';
    }
}
