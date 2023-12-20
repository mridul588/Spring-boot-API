package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Details")
public class Load {

    @Id
    @Column(name = "shipperId", unique = true, nullable = false, length = 36) // Assuming shipperId is a UUID
    private String shipperId;

    @Column(name = "loadinPoint")
    private String loadinPoint;

    @Column(name = "unloadingPoint")
    private String unloadingPoint;

    @Column(name = "productType")
    private String productType;

    @Column(name = "truckType")
    private String truckType;

    @Column(name = "noOfTrucks")
    private String noOfTrucks;

    @Column(name = "weight")
    private String weight;

    @Column(name = "optional")
    private String optional;

    @Column(name = "Date")
    private String date;

    public Load(String loadinPoint, String unloadingPoint, String productType, String truckType,
                String noOfTrucks, String weight, String optional, String shipperId, String date) {
        this.loadinPoint = loadinPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.optional = optional;
        this.shipperId = shipperId;
        this.date = date;
    }

    public Load() {
    }

    // Getter and Setter methods for all fields

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getLoadinPoint() {
        return loadinPoint;
    }

    public void setLoadinPoint(String loadinPoint) {
        this.loadinPoint = loadinPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(String noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
