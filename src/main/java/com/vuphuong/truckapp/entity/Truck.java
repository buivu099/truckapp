package com.vuphuong.truckapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "LicensePlate", nullable = false, length = 50)
    private String licensePlate;
    @Column(name = "Model", nullable = false, length = 50)
    private String model;
    @Column(name = "Color", length = 50)
    private String color;

    public Truck() {
    }

    public Truck(long id, String licensePlate, String model, String color) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
