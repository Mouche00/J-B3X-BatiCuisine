package models;

public class Workforce extends Component {

    private double hourlyRate;
    private double workHours;

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

    public Workforce(String id, String name, double VAT, Project project, double hourlyRate, double workHours) {
        super(id, name, VAT, project);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    public Workforce(String name, double VAT, Project project, double hourlyRate, double workHours) {
        super(name, VAT, project);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }
}
