package com.egen.orderproc.model;

import java.util.Arrays;

public class BareOrder {

    String order_id;
    String order_customer_id;
    String order_status = "New";
    Double order_subtotal;
    Double order_tax;
    Double order_shipping_charges;
    Double order_total;
    String order_shipping_type;
    String order_shipping_addressline1;
    String order_shipping_addressline2 = "";
    String order_shipping_city;
    String order_shipping_state;
    String order_shipping_zip;

    Items[] items;
    BarePayment[] payments;

    public BareOrder() {

    }

    public BareOrder(String order_id, String order_customer_id, String order_status, Double order_subtotal, Double order_tax, Double order_shipping_charges, Double order_total, String order_shipping_type, String order_shipping_addressline1, String order_shipping_addressline2, String order_shipping_city, String order_shipping_state, String order_shipping_zip) {
        this.order_id = order_id;
        this.order_customer_id = order_customer_id;
        this.order_status = order_status;
        this.order_subtotal = order_subtotal;
        this.order_tax = order_tax;
        this.order_shipping_charges = order_shipping_charges;
        this.order_total = order_total;
        this.order_shipping_type = order_shipping_type;
        this.order_shipping_addressline1 = order_shipping_addressline1;
        this.order_shipping_addressline2 = order_shipping_addressline2;
        this.order_shipping_city = order_shipping_city;
        this.order_shipping_state = order_shipping_state;
        this.order_shipping_zip = order_shipping_zip;
    }

    public BareOrder(String order_id, String order_customer_id, String order_status, Double order_subtotal, Double order_tax, Double order_shipping_charges, Double order_total, String order_shipping_type, String order_shipping_addressline1, String order_shipping_addressline2, String order_shipping_city, String order_shipping_state, String order_shipping_zip, Items[] items, BarePayment[] payments) {
        this.order_id = order_id;
        this.order_customer_id = order_customer_id;
        this.order_status = order_status;
        this.order_subtotal = order_subtotal;
        this.order_tax = order_tax;
        this.order_shipping_charges = order_shipping_charges;
        this.order_total = order_total;
        this.order_shipping_type = order_shipping_type;
        this.order_shipping_addressline1 = order_shipping_addressline1;
        this.order_shipping_addressline2 = order_shipping_addressline2;
        this.order_shipping_city = order_shipping_city;
        this.order_shipping_state = order_shipping_state;
        this.order_shipping_zip = order_shipping_zip;
        this.items = items;
        this.payments = payments;
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

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getOrder_subtotal() {
        return order_subtotal;
    }

    public void setOrder_subtotal(Double order_subtotal) {
        this.order_subtotal = order_subtotal;
    }

    public Double getOrder_tax() {
        return order_tax;
    }

    public void setOrder_tax(Double order_tax) {
        this.order_tax = order_tax;
    }

    public Double getOrder_shipping_charges() {
        return order_shipping_charges;
    }

    public void setOrder_shipping_charges(Double order_shipping_charges) {
        this.order_shipping_charges = order_shipping_charges;
    }

    public Double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Double order_total) {
        this.order_total = order_total;
    }

    public String getOrder_shipping_type() {
        return order_shipping_type;
    }

    public void setOrder_shipping_type(String order_shipping_type) {
        this.order_shipping_type = order_shipping_type;
    }

    public String getOrder_shipping_addressline1() {
        return order_shipping_addressline1;
    }

    public void setOrder_shipping_addressline1(String order_shipping_addressline1) {
        this.order_shipping_addressline1 = order_shipping_addressline1;
    }

    public String getOrder_shipping_addressline2() {
        return order_shipping_addressline2;
    }

    public void setOrder_shipping_addressline2(String order_shipping_addressline2) {
        this.order_shipping_addressline2 = order_shipping_addressline2;
    }

    public String getOrder_shipping_city() {
        return order_shipping_city;
    }

    public void setOrder_shipping_city(String order_shipping_city) {
        this.order_shipping_city = order_shipping_city;
    }

    public String getOrder_shipping_state() {
        return order_shipping_state;
    }

    public void setOrder_shipping_state(String order_shipping_state) {
        this.order_shipping_state = order_shipping_state;
    }

    public String getOrder_shipping_zip() {
        return order_shipping_zip;
    }

    public void setOrder_shipping_zip(String order_shipping_zip) {
        this.order_shipping_zip = order_shipping_zip;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public BarePayment[] getPayments() {
        return payments;
    }

    public void setPayments(BarePayment[] payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "BareOrder{" +
                "order_id='" + order_id + '\'' +
                ", order_customer_id='" + order_customer_id + '\'' +
                ", order_status='" + order_status + '\'' +
                ", order_subtotal=" + order_subtotal +
                ", order_tax=" + order_tax +
                ", order_shipping_charges=" + order_shipping_charges +
                ", order_total=" + order_total +
                ", order_shipping_type='" + order_shipping_type + '\'' +
                ", order_shipping_addressline1='" + order_shipping_addressline1 + '\'' +
                ", order_shipping_addressline2='" + order_shipping_addressline2 + '\'' +
                ", order_shipping_city='" + order_shipping_city + '\'' +
                ", order_shipping_state='" + order_shipping_state + '\'' +
                ", order_shipping_zip='" + order_shipping_zip + '\'' +
                ", items=" + Arrays.toString(items) +
                ", payments=" + Arrays.toString(payments) +
                '}';
    }
}
