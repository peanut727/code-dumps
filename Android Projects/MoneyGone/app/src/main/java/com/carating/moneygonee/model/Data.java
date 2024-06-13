package com.carating.moneygonee.model;

public class Data {

    private int amount;
    private String type;
    private String desc;
    private String id;
    private String date;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Data(int amount, String type, String desc, String id, String date) {
        this.amount = amount;
        this.type = type;
        this.desc = desc;
        this.id = id;
        this.date = date;
    }

    public Data() {

    }



}
