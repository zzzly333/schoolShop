package com.cqut.domain;

public class ShopCart {
    private String username;
    private String goodsno;
    private int num;

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
    @Override
    public String toString() {
        return "ShopCart{" +
                "username='" + username + '\'' +
                ", goodsno='" + goodsno + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
