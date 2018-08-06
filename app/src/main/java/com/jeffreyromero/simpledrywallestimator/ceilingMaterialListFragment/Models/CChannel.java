package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models;

public class CChannel extends Material {
    private int length;

    public CChannel(String description, float price, int length) {
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
