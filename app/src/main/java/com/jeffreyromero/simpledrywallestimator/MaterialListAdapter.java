package com.jeffreyromero.simpledrywallestimator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.ceilingMaterialListFragment.Models.Material;

import java.util.List;

/**
 * This is a RecyclerView adapter that uses item_view_2col layout.
 */
public class MaterialListAdapter extends RecyclerView.Adapter {
    private List<Material> list;
    private onItemClickListener onItemClickListener;
    private Context context;

    /**
     * @param list A list of Material.
     * @param context Usually the instantiating class.
     */
    MaterialListAdapter(List<Material> list, Context context) {
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
         * Click Listener for MaterialListAdapter
         * @param position The location of the clicked item in the list.
         */
        void onItemClick(int position);
    }

    /**
     * Set the implementing class to an instance variable.
     * @param onItemClickListener Usually an Activity but can be any class.
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
        viewHolder.columnLeftTV.setText(listItem.getDescription());
        viewHolder.columnRightTV.setText(String.valueOf(listItem.getPrice()));
    }

    /**
     * This custom ViewHolder is instantiated by onCreateViewHolder().
     * They accept an inflated layout and creates instance variables for each View in the layout.
     * These are then used by onBindViewHolder() to bind data to each View instance variable.
     */
    private class itemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView columnLeftTV;
        TextView columnRightTV;
        itemViewHolder(View itemView) {
            super(itemView);
            columnLeftTV = itemView.findViewById(R.id.columnLeftTV);
            columnRightTV = itemView.findViewById(R.id.columnRightTV);
            // Setting the click listener to the ViewHolder makes the entire row clickable.
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.getAdapterPosition());
            } else {
                Log.e("MaterialListAdapter", "Click listener not set");
            }
        }
    }
}
