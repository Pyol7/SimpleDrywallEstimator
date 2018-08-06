package com.jeffreyromero.simpledrywallestimator.mainActivity;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeffreyromero.simpledrywallestimator.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        view.findViewById(R.id.existing_projects_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((MainActivity) getActivity()).existingProjectsBtnClicked();
                } catch (Exception e) {
                    Log.e("MainActivityFragment()", "Error: " + e.getMessage());
                }
            }
        });
        return view;
    }

}