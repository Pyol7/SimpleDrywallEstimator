package com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;

import java.util.List;

import static android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY;
import static android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT;

/**
 * This is a RecyclerView adapter that uses item_view_2col layout.
 */
public class CeilingMaterialListAdapter extends RecyclerView.Adapter {
    private List<Material> list;
    private onItemClickListener onItemClickListener;
    private Context context;

    /**
     * @param list A list of Material.
     * @param context Usually the instantiating class.
     */
    CeilingMaterialListAdapter(List<Material> list, Context context) {
        this.list = list;
        this.context = context;
    }

    /**
     * Any class that implements this interface becomes a type of this interface and therefore
     * can be registered to an instance variable using setItemClickListener.
     * Once registered any of the implemented methods can be called on it.
     */
    public interface onItemClickListener{
        /**
         * Click Listener for CeilingMaterialListAdapter
         * @param updatedCeilingMaterialList The Material at the clicked position in the list.
         */
        void onItemClick(List<Material> updatedCeilingMaterialList);
    }

    /**
     * Set the implementing class to an instance variable.
     * @param onItemClickListener Usually an Activity or Fragment but can be any class.
     */
    public void setItemClickListener(onItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * Called by RecyclerView to determine the size of the data set.
     * @return Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Called by RecyclerView when it needs a new ViewHolder.
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View passed in from getItemViewType().
     * @return A ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the item view layout
        View itemView = inflater.inflate(R.layout.item_view_2col, parent, false);
        return new itemViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to bind data to the ViewHolder.
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Material listItem = list.get(position);
        itemViewHolder viewHolder = (itemViewHolder) holder;
        viewHolder.columnLeftET.setText(listItem.getDescription());
        viewHolder.columnRightET.setText(String.valueOf(listItem.getPrice()));
    }

    /**
     * This custom ViewHolder is instantiated by onCreateViewHolder().
     * They accept an inflated layout and creates instance variables for each View in the layout.
     * These are then used by onBindViewHolder() to bind data to each View instance variable.
     */
    private class itemViewHolder extends RecyclerView.ViewHolder {
        InputMethodManager imm;
        TextView columnLeftET;
        TextView columnRightET;
        itemViewHolder(final View itemView) {
            super(itemView);
            imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            // Get EditText and create TextView appearance
            columnLeftET = itemView.findViewById(R.id.columnLeftET);
            columnLeftET.setFocusable(false);
            columnLeftET.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    columnLeftET.setFocusableInTouchMode(true);
                    imm.showSoftInput(columnLeftET, SHOW_IMPLICIT);
                    return true;
                }
            });
            columnLeftET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    // Ensure that imeOptions="actionDone" is set in layout
                    if(actionId== EditorInfo.IME_ACTION_DONE){
                        //Clear focus here from edittext
                        columnLeftET.setFocusable(false);
                        imm.hideSoftInputFromWindow(columnLeftET.getWindowToken(), 0);
                    }
                    // Get list item at position
                    Material listItem = list.get(itemViewHolder.this.getAdapterPosition());
                    // TODO input validation and columnRight. Also make this adaptor fully custom
                    listItem.setDescription(String.valueOf(columnLeftET.getText()));
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClick(list);
//                    } else {
//                        Log.e("CeilingMaterialListAda", "Click listener not set");
//                    }
                    return true;
                }
            });

            columnRightET = itemView.findViewById(R.id.columnRightET);
            columnRightET.setFocusable(false);
            columnRightET.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    columnRightET.setFocusableInTouchMode(true);
                    imm.showSoftInput(columnRightET, SHOW_IMPLICIT);
                    return true;
                }
            });
            columnRightET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    // Ensure that imeOptions="actionDone" is set in layout
                    if(actionId== EditorInfo.IME_ACTION_DONE){
                        columnRightET.setFocusable(false);
                        imm.hideSoftInputFromWindow(columnRightET.getWindowToken(), HIDE_IMPLICIT_ONLY);
                    }
                    // Set user input to list item
                    Material listItem = list.get(itemViewHolder.this.getAdapterPosition());
                    // TODO input validation
                    listItem.setPrice(Float.valueOf(String.valueOf(columnRightET.getText())));
//                    Toast.makeText(context, "" + newText + " @ " + itemViewHolder.this.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }
}
