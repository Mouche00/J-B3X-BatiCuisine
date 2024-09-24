package models;

public class Material extends Component {

    private double price;
    private double quantity;
    private double transportationCost;
    private double qualityCoefficient;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(double transportationCost) {
        this.transportationCost = transportationCost;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }

    public Material(String id, String name, double VAT, Project project, double price, double quantity, double transportationCost, double qualityCoefficient) {
        super(id, name, VAT, project);
        this.price = price;
        this.quantity = quantity;
        this.transportationCost = transportationCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public Material(String name, double VAT, Project project, double price, double quantity, double transportationCost, double qualityCoefficient) {
        super(name, VAT, project);
        this.price = price;
        this.quantity = quantity;
        this.transportationCost = transportationCost;
        this.qualityCoefficient = qualityCoefficient;
    }
}
