package com.jeffreyromero.simpledrywallestimator.projectActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jeffreyromero.simpledrywallestimator.R;
import com.jeffreyromero.simpledrywallestimator.mainActivity.MainActivity;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.Project;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.ProjectListHeader;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.ProjectListItem;

import java.util.ArrayList;


/**
 * This adapter is used to connect the list_fragment to data from ProjectListBuilder
 */
public class ProjectListAdapter extends RecyclerView.Adapter {
    private ArrayList<ProjectListItem> projectList;
    private Context context;
    // Declare view types
    private static final int HEADER_VIEW_TYPE = 0;
    private static final int LIST_VIEW_TYPE = 1;

    ProjectListAdapter(ArrayList<ProjectListItem> projectList, Context context) {
        this.projectList = projectList;
        this.context = context;
    }

    /**
     * Called by RecyclerView to determine the size of the data set.
     *
     * @return Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return projectList.size();
    }

    /**
     * Called by RecyclerView to determines the view type.
     * If no match is found (or no custom implementation is provided) then it calls The default
     * implementation which returns 0, making the assumption of a single view type for the adapter.
     * In this case the implementation is purely custom so the code must halt execution and
     * inform the user if no match is found.
     *
     * @param position An integer value identifying the type of the view needed to represent
     *                 the item at position. Type codes need not be contiguous.
     *
     * @return The view type.
     */
    @Override
    public int getItemViewType(int position) {
        ProjectListItem project = projectList.get(position);
        // Check the type of class and return the appropriate identifier
        if (project instanceof ProjectListHeader) {
            return HEADER_VIEW_TYPE;
        } else {
            return LIST_VIEW_TYPE;
        }
    }

    /**
     * Called by RecyclerView needs it needs a new ViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position (ie RecyclerView ViewGroup in activity_main).
     *
     * @param viewType The view type of the new View passed in from getItemViewType().
     *
     * @return A ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get the inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        // Declare the row view
        View itemView;
        // Inflate layout according to view type
        if (viewType == HEADER_VIEW_TYPE){
            itemView = inflater.inflate(R.layout.list_item_2col_header, parent, false);
            return new HeaderViewHolder(itemView);
        } else if (viewType == LIST_VIEW_TYPE) {
            itemView = inflater.inflate(R.layout.item_view_2col, parent, false);
            return new ProjectViewHolder(itemView);
        }
        return null;
    }

    /**
     * Called by RecyclerView to bind data to the ViewHolder.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *               item at the given position in the data set.
     *
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProjectListItem projectListItem = projectList.get(position);
        // Check holder type and add data accordingly
        if (holder instanceof HeaderViewHolder){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            ProjectListHeader header = (ProjectListHeader) projectListItem;
            // Set data
            headerViewHolder.columnLeftTV.setText(header.getHeaderName());
            headerViewHolder.columnRightTV.setText(header.getHeaderDate());

        } else if (holder instanceof ProjectViewHolder){
            ProjectViewHolder projectViewHolder = (ProjectViewHolder) holder;
            Project project = (Project) projectListItem;
            // Set data
            projectViewHolder.columnLeftTV.setText(project.getProjectName());
            projectViewHolder.columnRightTV.setText(project.getProjectDate());
        }
    }

    /**
     * These custom ViewHolders are instantiated by onCreateViewHolder() based on view type.
     * They accept an inflated layout and creates instance variables for each View in the layout.
     * These are then used by onBindViewHolder() to bind data to each View instance variable.
     */
    private class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView columnLeftTV;
        TextView columnRightTV;
        HeaderViewHolder(View itemView) {
            super(itemView);
            columnLeftTV = itemView.findViewById(R.id.columnLeftTV);
            columnRightTV = itemView.findViewById(R.id.columnRightTV);
        }
    }

    private class ProjectViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView columnLeftTV;
        TextView columnRightTV;
        ProjectViewHolder(View itemView) {
            super(itemView);
            columnLeftTV = itemView.findViewById(R.id.columnLeftTV);
            columnRightTV = itemView.findViewById(R.id.columnRightTV);
            // Set click listener to this ViewHolder
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            try {
                ((MainActivity) context).projectListItemClicked(this.getAdapterPosition());
            } catch (Exception e) {
                Log.e("ProjectListAdapter()", "Error: " + e.getMessage());
            }
        }
    }
}
