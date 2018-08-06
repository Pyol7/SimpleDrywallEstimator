package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeffreyromero.simpledrywallestimator.MaterialActivity.MaterialActivity;
import com.jeffreyromero.simpledrywallestimator.MaterialListAdapter;
import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * @Return A fragment containing a list of Ceiling Materials
 */
public class CeilingMaterialListFragment extends Fragment  implements
        CeilingMaterialListAdapter.onItemClickListener {

    List<Material> ceilingMaterialList;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set context
        this.context = inflater.getContext();
        // Create/Load ceiling material list from shared preferences
        loadData();
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.ceiling_material_list_fragment, container, false);
        // Get the parent fragment view
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        // Instantiate the adaptor
        CeilingMaterialListAdapter adapter = new CeilingMaterialListAdapter(
                ceilingMaterialList,
                context);
        rv.setAdapter(adapter);
        adapter.setItemClickListener(this);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        Button saveBtn = view.findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(ceilingMaterialList);
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /**
     * Click Listener for CeilingMaterialListAdapter
     *
     * @param updatedCeilingMaterialList The Material at the clicked position in the list.
     */
    @Override
    public void onItemClick(List<Material> updatedCeilingMaterialList) {
        ceilingMaterialList = updatedCeilingMaterialList;
    }

    private void saveData(List<Material> ceilingMaterialList) {
        SharedPreferences sp = context.getSharedPreferences("shared_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(ceilingMaterialList);
        editor.putString("updatedCeilingMaterialList", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sp = context.getSharedPreferences("shared_preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("updatedCeilingMaterialList", null);
        Type type = new TypeToken<ArrayList<Material>>() {
        }.getType();
        ceilingMaterialList = gson.fromJson(json, type);

        if (ceilingMaterialList == null) {
            ceilingMaterialList = MaterialList.getDefaultCeilingMaterialList();
        }
    }

    public CeilingMaterialListFragment() {
        // Required empty public constructor
    }
}
