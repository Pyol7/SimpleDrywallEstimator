package com.jeffreyromero.simpledrywallestimator.MaterialActivity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.CeilingMaterialListAdapter;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.CeilingMaterialListFragment;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;

public class MaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.fragment_container) != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_container, new CeilingMaterialListFragment());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.editMaterialList_mi) {
            Intent Intent = new Intent(this, MaterialActivity.class);
            startActivity(Intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
