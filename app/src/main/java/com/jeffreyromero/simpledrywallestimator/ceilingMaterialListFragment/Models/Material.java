package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models;

/**
 * This is the base class for all Materials.
 *
 */
public class Material {
    private String description;
    private float price;

    public Material() {
    }

    public Material(String description, float price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
