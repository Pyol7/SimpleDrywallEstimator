package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models;

public class FurringChannel extends Material {
    private int length;

    public FurringChannel(String description, float price, int length) {
        super(description, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
