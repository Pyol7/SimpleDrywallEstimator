package com.jeffreyromero.simpledrywallestimator.projectActivity.Models;

public class Project extends ProjectListItem {
    private String projectName;
    private String projectDate;

    public Project(String projectName, String projectDate) {
        this.projectName = projectName;
        this.projectDate = projectDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDate() {
        return projectDate;
    }
}
