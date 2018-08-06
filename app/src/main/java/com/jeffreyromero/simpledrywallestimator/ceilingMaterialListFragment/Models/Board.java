package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models;

public class Board extends Material {
    private int length;
    private int width;

    public Board(String description, float price, int length, int width) {
        super(description, price);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
