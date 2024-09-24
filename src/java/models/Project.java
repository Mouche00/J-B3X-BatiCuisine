package models;

import utils.ID;
import utils.enums.ProjectStatus;

import java.util.List;

public class Project {

    private String id;
    private String title;
    private double margin;
    private ProjectStatus status;
    private Client client;
    private List<Component> components;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Project(String id, String title, double margin, ProjectStatus status, Client client) {
        this.id = id;
        this.title = title;
        this.margin = margin;
        this.status = status;
        this.client = client;
    }

    public Project(String title, double margin, Client client) {
        this.id = ID.generate();
        this.title = title;
        this.margin = margin;
        this.status = ProjectStatus.ONGOING;
        this.client = client;
    }

    @Override
    public String toString() {
        return "\n\tID: " + id +
                "\n\tTitle: " + title +
                "\n\tMargin: " + margin +
                "\n\tStatus: " + status +
                "\n\tClient: " + client.getName();
    }
}
