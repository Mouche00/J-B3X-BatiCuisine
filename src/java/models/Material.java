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

    public Material(String id, String name, Project project, double price, double quantity, double transportationCost, double qualityCoefficient) {
        super(id, name, project);
        this.price = price;
        this.quantity = quantity;
        this.transportationCost = transportationCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public Material(String name, Project project, double price, double quantity, double transportationCost, double qualityCoefficient) {
        super(name, project);
        this.price = price;
        this.quantity = quantity;
        this.transportationCost = transportationCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    @Override
    public String toString() {
        return "Price: " + price + "€/m²" +
                ", Quantity: " + quantity + "m²" +
                ", Transportation cost: " + transportationCost + "€" +
                ", Quality coefficient: " + qualityCoefficient;
    }
}
