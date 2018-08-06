package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment;

import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Board;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.CChannel;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.DrywallScrew;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.FramingScrew;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.FurringChannel;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.JointCompound;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.JointTape;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Nail;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.SDScrew;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.SandPaper;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.WallAngle;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Wire;

import java.util.ArrayList;

public class MaterialList {
    private static ArrayList<Material> defaultCeilingMaterialList;

    private MaterialList() {
    }

    public static ArrayList<Material> getDefaultCeilingMaterialList() {
        if (defaultCeilingMaterialList == null) {
            defaultCeilingMaterialList = new ArrayList<>();
            defaultCeilingMaterialList.add(new Board("Ultra Light Board (1/2in)", 74.00f, 8, 4));
            defaultCeilingMaterialList.add(new FurringChannel("Furring Channel", 15.25f, 12));
            defaultCeilingMaterialList.add(new CChannel("Gypsum 'C' Channel", 51.50f, 16));
            defaultCeilingMaterialList.add(new WallAngle("Metal Wall Angle", 8.50f, 10));
            defaultCeilingMaterialList.add(new DrywallScrew("Drywall Screws (1 1/2\")", 0.15f));
            defaultCeilingMaterialList.add(new SDScrew("Self Drill Screws (7/16\")", 0.012f));
            defaultCeilingMaterialList.add(new FramingScrew("Framing Screws (7/16\")", 0.10f));
            defaultCeilingMaterialList.add(new Nail("Concrete Nail (1/2\")", 0.13f));
            defaultCeilingMaterialList.add(new JointCompound("Joint Compound (5gal)", 130.00f));
            defaultCeilingMaterialList.add(new JointTape("Joint Tape (Paper)(500ft)", 42.00f));
            defaultCeilingMaterialList.add(new SandPaper("Sand Paper (Sheet)", 5.00f));
            defaultCeilingMaterialList.add(new Wire("Wire (14g)(ib)", 9.50f));
        }
        return defaultCeilingMaterialList;
    }
}
