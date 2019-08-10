package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "oldhouseinfo", schema = "huantai", catalog = "")
public class OldhouseinfoEntity {
    private int id;
    private String oldhouseid;
    private String headline;
    private int price;
    private int unitprice;
    private String area;
    private String housetype;
    private String imgid;
    private String locationid;
    private Date buildingtime;
    private String buildinghead;
    private String floor;
    private String heatingsystem;
    private String housenianxian;
    private String chanquannianxian;
    private String mortgageinfo;
    private String havecertificate;
    private String whoproperty;

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
    @Column(name = "oldhouseid")
    public String getOldhouseid() {
        return oldhouseid;
    }

    public void setOldhouseid(String oldhouseid) {
        this.oldhouseid = oldhouseid;
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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "unitprice")
    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "housetype")
    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    @Basic
    @Column(name = "imgid")
    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    @Basic
    @Column(name = "locationid")
    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "buildingtime")
    public Date getBuildingtime() {
        return buildingtime;
    }

    public void setBuildingtime(Date buildingtime) {
        this.buildingtime = buildingtime;
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
    @Column(name = "floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "heatingsystem")
    public String getHeatingsystem() {
        return heatingsystem;
    }

    public void setHeatingsystem(String heatingsystem) {
        this.heatingsystem = heatingsystem;
    }

    @Basic
    @Column(name = "housenianxian")
    public String getHousenianxian() {
        return housenianxian;
    }

    public void setHousenianxian(String housenianxian) {
        this.housenianxian = housenianxian;
    }

    @Basic
    @Column(name = "chanquannianxian")
    public String getChanquannianxian() {
        return chanquannianxian;
    }

    public void setChanquannianxian(String chanquannianxian) {
        this.chanquannianxian = chanquannianxian;
    }

    @Basic
    @Column(name = "mortgageinfo")
    public String getMortgageinfo() {
        return mortgageinfo;
    }

    public void setMortgageinfo(String mortgageinfo) {
        this.mortgageinfo = mortgageinfo;
    }

    @Basic
    @Column(name = " havecertificate")
    public String getHavecertificate() {
        return havecertificate;
    }

    public void setHavecertificate(String havecertificate) {
        this.havecertificate = havecertificate;
    }

    @Basic
    @Column(name = "whoproperty")
    public String getWhoproperty() {
        return whoproperty;
    }

    public void setWhoproperty(String whoproperty) {
        this.whoproperty = whoproperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldhouseinfoEntity that = (OldhouseinfoEntity) o;
        return id == that.id &&
                price == that.price &&
                unitprice == that.unitprice &&
                Objects.equals(oldhouseid, that.oldhouseid) &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(area, that.area) &&
                Objects.equals(housetype, that.housetype) &&
                Objects.equals(imgid, that.imgid) &&
                Objects.equals(locationid, that.locationid) &&
                Objects.equals(buildingtime, that.buildingtime) &&
                Objects.equals(buildinghead, that.buildinghead) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(heatingsystem, that.heatingsystem) &&
                Objects.equals(housenianxian, that.housenianxian) &&
                Objects.equals(chanquannianxian, that.chanquannianxian) &&
                Objects.equals(mortgageinfo, that.mortgageinfo) &&
                Objects.equals(havecertificate, that.havecertificate) &&
                Objects.equals(whoproperty, that.whoproperty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oldhouseid, headline, price, unitprice, area, housetype, imgid, locationid, buildingtime, buildinghead, floor, heatingsystem, housenianxian, chanquannianxian, mortgageinfo, havecertificate, whoproperty);
    }
}
