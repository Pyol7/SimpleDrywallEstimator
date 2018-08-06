package com.jeffreyromero.simpledrywallestimator.projectActivity.Models;

public class ProjectListHeader extends ProjectListItem {
    private String headerName;
    private String headerDate;

    public ProjectListHeader(String headerName, String headerDate) {
        this.headerName = headerName;
        this.headerDate = headerDate;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getHeaderDate() {
        return headerDate;
    }
}
