package models;

import utils.ID;

import java.time.LocalDate;

public class Invoice {

    private String id;
    private double overallCost;
    private LocalDate issuedAt;
    private LocalDate validatedAt;
    private Project project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getOverallCost() {
        return overallCost;
    }

    public void setOverallCost(double overallCost) {
        this.overallCost = overallCost;
    }

    public LocalDate getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDate issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDate getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(LocalDate validatedAt) {
        this.validatedAt = validatedAt;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Invoice(String id, double overallCost, LocalDate issuedAt, LocalDate validatedAt, Project project) {
        this.id = id;
        this.overallCost = overallCost;
        this.issuedAt = issuedAt;
        this.validatedAt = validatedAt;
        this.project = project;
    }

    public Invoice(double overallCost, LocalDate issuedAt, LocalDate validatedAt, Project project) {
        this.id = ID.generate();
        this.overallCost = overallCost;
        this.issuedAt = issuedAt;
        this.validatedAt = validatedAt;
        this.project = project;
    }

    @Override
    public String toString() {
        return "\n\tID: " + id +
                "\n\tOverall cost: " + overallCost +
                "\n\tIssued at: " + issuedAt +
                "\n\tValidated at: " + validatedAt +
                "\n\tProject: " + project;
    }
}
