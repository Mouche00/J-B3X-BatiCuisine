package models;

import utils.ID;
import utils.enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String id;
    private String title;
    private double VAT;
    private double discount;
    private double margin;
    private ProjectStatus status;
    private Client client;
    private List<Material> materials = new ArrayList<>();
    private List<Workforce> workforces = new ArrayList<>();

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

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Workforce> getWorkforces() {
        return workforces;
    }

    public void setWorkforces(List<Workforce> workforces) {
        this.workforces = workforces;
    }

    public Project(String id, String title, double VAT, double discount, double margin, ProjectStatus status) {
        this.id = id;
        this.title = title;
        this.VAT = VAT;
        this.discount = discount;
        this.margin = margin;
        this.status = status;
        this.client = client;
    }

    public Project(String title, double VAT, double discount, double margin) {
        this.id = ID.generate();
        this.title = title;
        this.VAT = VAT;
        this.discount = discount;
        this.margin = margin;
        this.status = ProjectStatus.ONGOING;
        this.client = client;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\n\tTitle: " + title +
                "\n\tVAT: " + VAT +
                "\n\tDiscount: " + discount +
                "\n\tMargin: " + margin +
                "\n\tStatus: " + status +
                "\n\tClient: " + client.getName();
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void addWorkforce(Workforce workforce) {
        workforces.add(workforce);
    }
}
