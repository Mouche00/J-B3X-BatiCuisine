package models;

import utils.enums.ProjectStatus;

public class Project {

    private int id;
    private String title;
    private double margin;
    private ProjectStatus status;
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Project(int id, String title, double margin, ProjectStatus status, Client client) {
        this.id = id;
        this.title = title;
        this.margin = margin;
        this.status = status;
        this.client = client;
    }

    public Project(String title, double margin, ProjectStatus status, Client client) {
        this.title = title;
        this.margin = margin;
        this.status = status;
        this.client = client;
    }
}
