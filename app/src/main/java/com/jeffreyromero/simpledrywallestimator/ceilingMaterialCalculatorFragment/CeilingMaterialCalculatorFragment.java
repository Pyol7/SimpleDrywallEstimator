package com.jeffreyromero.simpledrywallestimator.ceilingMaterialCalculatorFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.CeilingMaterialListFragment;


/**
 * @Return A fragment containing a list of Ceiling Materials and their quantities
 * calculated based on user input.
 */
public class CeilingMaterialCalculatorFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.ceiling_material_calculator, container, false);

        // TO DO: ADD FRAGMENT INTO FRAGMENT

        if (view.findViewById(R.id.fragment_container) != null) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.add(R.id.fragment_container, new CeilingMaterialListFragment());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }

        return view;
    }

    public CeilingMaterialCalculatorFragment() {
        // Required empty public constructor
    }
}
