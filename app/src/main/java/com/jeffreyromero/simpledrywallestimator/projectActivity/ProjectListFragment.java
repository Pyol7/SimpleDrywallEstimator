package com.jeffreyromero.simpledrywallestimator.projectActivity;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.ProjectListItem;

import java.util.ArrayList;


/**
 * @Return A fragment containing a list of projects
 */
public class ProjectListFragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        // Get the parent fragment view
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        // Build project list
        ArrayList<ProjectListItem> list = new ProjectListBuilder().getList();
        // Instantiate the adaptor
        ProjectListAdapter adapter = new ProjectListAdapter(
                list,
                getActivity());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public ProjectListFragment() {
        // Required empty public constructor
    }
}
