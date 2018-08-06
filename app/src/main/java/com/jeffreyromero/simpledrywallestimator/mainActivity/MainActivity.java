package com.jeffreyromero.simpledrywallestimator.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jeffreyromero.simpledrywallestimator.MaterialActivity.MaterialActivity;
import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.MaterialListAdapter;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialCalculatorFragment.CeilingMaterialCalculatorFragment;
import com.jeffreyromero.simpledrywallestimator.projectActivity.ProjectListFragment;

public class MainActivity extends AppCompatActivity implements
        MaterialListAdapter.onItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.fragment_container) != null) {
            // If we're being restored from a previous state,
            // then return to avoid overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_container, new MainActivityFragment());
            ft.commit();
        }
    }

    /**
     * Existing projects button clicked in MainActivityFragment
     */
    public void existingProjectsBtnClicked(){
//        Toast.makeText(this,"existingProjectsBtnClicked: ", Toast.LENGTH_SHORT).show();
        if (findViewById(R.id.fragment_container) != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new ProjectListFragment());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    /**
     * Project list item clicked in ProjectListAdapter
     */
    public void projectListItemClicked(int id){
//        Toast.makeText(this,"projectListItemClicked: " + id, Toast.LENGTH_SHORT).show();
        if (findViewById(R.id.fragment_container) != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new CeilingMaterialCalculatorFragment());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    /**
     * Ceiling Material list item clicked in ListAdapter2Col2ViewTypes_todo
     */
    public void ceilingMaterialListItemClicked(int id){
        Toast.makeText(this,"ceilingMaterialListItemClicked: " + id, Toast.LENGTH_SHORT).show();
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
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Click Listener for MaterialListAdapter
     * @param position The location of the clicked item in the list.
     */
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"MaterialListAdapter clicked at " + position, Toast.LENGTH_SHORT).show();
    }
}
