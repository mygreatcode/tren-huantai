package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rentinghouseinfo", schema = "houseproperty", catalog = "")
public class RentinghouseinfoEntity {
    private int id;
    private String headline;
    private String rentinghouseid;
    private Integer price;
    private String payway;
    private String eara;
    private String housestructure;
    private int locationid;
    private String floor;
    private String decorated;
    private String buildinghead;
    private String housecode;
    private String deployid;
    private String describe;
    private Integer imgid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "headline")
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Basic
    @Column(name = "rentinghouseid")
    public String getRentinghouseid() {
        return rentinghouseid;
    }

    public void setRentinghouseid(String rentinghouseid) {
        this.rentinghouseid = rentinghouseid;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "payway")
    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    @Basic
    @Column(name = "eara")
    public String getEara() {
        return eara;
    }

    public void setEara(String eara) {
        this.eara = eara;
    }

    @Basic
    @Column(name = "housestructure")
    public String getHousestructure() {
        return housestructure;
    }

    public void setHousestructure(String housestructure) {
        this.housestructure = housestructure;
    }

    @Basic
    @Column(name = "locationid")
    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "decorated")
    public String getDecorated() {
        return decorated;
    }

    public void setDecorated(String decorated) {
        this.decorated = decorated;
    }

    @Basic
    @Column(name = "buildinghead")
    public String getBuildinghead() {
        return buildinghead;
    }

    public void setBuildinghead(String buildinghead) {
        this.buildinghead = buildinghead;
    }

    @Basic
    @Column(name = "housecode")
    public String getHousecode() {
        return housecode;
    }

    public void setHousecode(String housecode) {
        this.housecode = housecode;
    }

    @Basic
    @Column(name = "deployid")
    public String getDeployid() {
        return deployid;
    }

    public void setDeployid(String deployid) {
        this.deployid = deployid;
    }

    @Basic
    @Column(name = "described")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "imgid")
    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentinghouseinfoEntity that = (RentinghouseinfoEntity) o;
        return id == that.id &&
                locationid == that.locationid &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(rentinghouseid, that.rentinghouseid) &&
                Objects.equals(price, that.price) &&
                Objects.equals(payway, that.payway) &&
                Objects.equals(eara, that.eara) &&
                Objects.equals(housestructure, that.housestructure) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(decorated, that.decorated) &&
                Objects.equals(buildinghead, that.buildinghead) &&
                Objects.equals(housecode, that.housecode) &&
                Objects.equals(deployid, that.deployid) &&
                Objects.equals(describe, that.describe) &&
                Objects.equals(imgid, that.imgid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, rentinghouseid, price, payway, eara, housestructure, locationid, floor, decorated, buildinghead, housecode, deployid, describe, imgid);
    }
}
