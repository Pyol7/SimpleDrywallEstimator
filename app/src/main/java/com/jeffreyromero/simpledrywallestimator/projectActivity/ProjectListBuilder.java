package com.jeffreyromero.simpledrywallestimator.projectActivity;

import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.Project;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.ProjectListHeader;
import com.jeffreyromero.simpledrywallestimator.projectActivity.Models.ProjectListItem;

import java.util.ArrayList;

/**
 * Builds a list of Projects.
 * The adapter binds the data in sequential order.
 */
public class ProjectListBuilder {
    private ArrayList<ProjectListItem> projectList;

    ProjectListBuilder() {
        // Instantiate list
        projectList = new ArrayList<>();
        // Add header
        projectList.add(new ProjectListHeader("Name", "Date"));
        // Add projects
        projectList.add(new Project("Fairways", "Mon 12th June"));
        projectList.add(new Project("La Riviera", "Fri 07th May"));
        projectList.add(new Project("St.Ann's", "Sun 24th Dec"));
    }

    public ArrayList<ProjectListItem> getList() {
        return projectList;
    }

}
