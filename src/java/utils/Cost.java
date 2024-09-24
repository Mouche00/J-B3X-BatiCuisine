package utils;

import java.util.HashMap;
import java.util.Map;

public class Cost {
    private Map<String, Double> componentCosts = new HashMap<>();
    private double materialsTotalNoVAT;
    private double workforcesTotalNoVAT;
    private double materialsTotalWithVAT;
    private double workforcesTotalWithVAT;
    private double totalCostNoMargin;
    private double margin;
    private double totalCost;

    public Map<String, Double> getComponentCosts() {
        return componentCosts;
    }

    public void setComponentCosts(Map<String, Double> componentCosts) {
        this.componentCosts = componentCosts;
    }

    public double getMaterialsTotalNoVAT() {
        return materialsTotalNoVAT;
    }

    public void setMaterialsTotalNoVAT(double materialsTotalNoVAT) {
        this.materialsTotalNoVAT = materialsTotalNoVAT;
    }

    public double getWorkforcesTotalNoVAT() {
        return workforcesTotalNoVAT;
    }

    public void setWorkforcesTotalNoVAT(double workforcesTotalNoVAT) {
        this.workforcesTotalNoVAT = workforcesTotalNoVAT;
    }

    public double getMaterialsTotalWithVAT() {
        return materialsTotalWithVAT;
    }

    public void setMaterialsTotalWithVAT(double materialsTotalWithVAT) {
        this.materialsTotalWithVAT = materialsTotalWithVAT;
    }

    public double getWorkforcesTotalWithVAT() {
        return workforcesTotalWithVAT;
    }

    public void setWorkforcesTotalWithVAT(double workforcesTotalWithVAT) {
        this.workforcesTotalWithVAT = workforcesTotalWithVAT;
    }

    public double getTotalCostNoMargin() {
        return totalCostNoMargin;
    }

    public void setTotalCostNoMargin(double totalCostNoMargin) {
        this.totalCostNoMargin = totalCostNoMargin;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void addComponentCost(String component, double cost) {
        this.componentCosts.put(component, cost);
    }

    public double getComponentCost(String component) {
        return componentCosts.get(component);
    }
}
