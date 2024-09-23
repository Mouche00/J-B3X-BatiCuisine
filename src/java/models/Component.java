package models;

abstract public class Component {

    protected int id;
    protected String name;
    protected double VAT;
    protected Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Component(int id, String name, double VAT, Project project) {
        this.id = id;
        this.name = name;
        this.VAT = VAT;
        this.project = project;
    }

    public Component(String name, double VAT, Project project) {
        this.name = name;
        this.VAT = VAT;
        this.project = project;
    }
}
