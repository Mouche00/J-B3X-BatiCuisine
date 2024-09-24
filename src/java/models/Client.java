package models;

import utils.ID;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String id;
    private String name;
    private String address;
    private String phone;
    private boolean isProfessional;
    private List<Project> projects;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsProfessional() {
        return isProfessional;
    }

    public void setIsProfessional(boolean professional) {
        isProfessional = professional;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Client(String id, String name, String address, String phone, boolean isProfessional) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;
    }

    public Client(String name, String address, String phone, boolean isProfessional) {
        this.id = ID.generate();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isProfessional = isProfessional;
        this.projects = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "\tID: " + id +
                "\n\tName: " + name +
                "\n\tAddress: " + address +
                "\n\tPhone: " + phone +
                "\n\tisProfessional: " + isProfessional;
    }
}
