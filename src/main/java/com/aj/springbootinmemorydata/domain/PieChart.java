package com.aj.springbootinmemorydata.domain;

public class PieChart {

    private String name;
    private int y;

    public PieChart(String name, int y) {
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
