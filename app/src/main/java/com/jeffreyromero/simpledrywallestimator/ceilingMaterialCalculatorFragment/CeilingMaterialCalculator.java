package com.jeffreyromero.simpledrywallestimator.ceilingMaterialCalculatorFragment;

import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;

import java.util.ArrayList;

public class CeilingMaterialCalculator {
    private String roomName;
    private Float length;
    private Float width;
    private ArrayList<Material> list;

    public CeilingMaterialCalculator(String roomName,
                                     Float length,
                                     Float width,
                                     ArrayList<Material> list) {
        this.roomName = roomName;
        this.length = length;
        this.width = width;
        this.list = list;
    }


}
