package com.cqut.domain;

import java.sql.Date;

public class Order {
    private String username;
    private String goodsno;
    private String goodsName;
    private String goodsImage;
    private float sumPrice;
    private int num;
    private Date date;

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Order(String username, String goodsno, String goodsName,String goodsImage, float v, int num, Date date) {
        this.username = username;
        this.goodsno = goodsno;
        this.goodsName = goodsName;
        this.goodsImage = goodsImage;
        this.sumPrice = v;
        this.num = num;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

