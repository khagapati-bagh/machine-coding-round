package com.udaan.models;

import java.util.Date;
import java.util.UUID;

public class Deal {
    private String dealId;
    private String dealName;
    private int noOfItems;
    private double dealPrice;
    private Long expireDate;

    public Deal(String dealName, int noOfItems, double dealPrice, Long expireDate) {
        this.dealId = UUID.randomUUID().toString();
        this.dealName = dealName;
        this.noOfItems = noOfItems;
        this.dealPrice = dealPrice;
        this.expireDate = expireDate;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }
}
