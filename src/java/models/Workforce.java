package models;

public class Workforce extends Component {

    private double hourlyRate;
    private double workHours;
    private double productivityCoefficient;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double getProductivityCoefficient() {
        return productivityCoefficient;
    }

    public void setProductivityCoefficient(double productivityCoefficient) {
        this.productivityCoefficient = productivityCoefficient;
    }

    public Workforce(String id, String name, Project project, double hourlyRate, double workHours, double productivityCoefficient) {
        super(id, name, project);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.productivityCoefficient = productivityCoefficient;
    }

    public Workforce(String name, Project project, double hourlyRate, double workHours, double productivityCoefficient) {
        super(name, project);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.productivityCoefficient = productivityCoefficient;
    }

    @Override
    public String toString() {
        return ", Hourly rate: " + hourlyRate + "€/h" +
                ", Work hours: " + workHours + "h" +
                ", Productivity coefficient: " + productivityCoefficient;
    }
}
