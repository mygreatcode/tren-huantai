package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "houseinfo", schema = "houseproperty", catalog = "")
@IdClass(HouseinfoEntityPK.class)
public class HouseinfoEntity {
    private int id;
    private String houseid;
    private String headline;
    private int price;
    private String housetype;
    private String area;
    private String previewimgurl;
    private String xiaoqu;
    private String location;
    private Date buildingtime;
    private String buildinghead;
    private String floor;
    private int unitprice;
    private String downpayment;
    private String monthlypay;
    private String decorated;
    private String sellingpoints;
    private String houseencoding;
    private Timestamp releasetime;
    private String imgid;
    private String locationid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "houseid")
    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
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
    @Column(name = "housetype")
    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
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
    @Column(name = "previewimgurl")
    public String getPreviewimgurl() {
        return previewimgurl;
    }

    public void setPreviewimgurl(String previewimgurl) {
        this.previewimgurl = previewimgurl;
    }

    @Basic
    @Column(name = "xiaoqu")
    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @Column(name = "unitprice")
    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "downpayment")
    public String getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(String downpayment) {
        this.downpayment = downpayment;
    }

    @Basic
    @Column(name = "monthlypay")
    public String getMonthlypay() {
        return monthlypay;
    }

    public void setMonthlypay(String monthlypay) {
        this.monthlypay = monthlypay;
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
    @Column(name = "sellingpoints")
    public String getSellingpoints() {
        return sellingpoints;
    }

    public void setSellingpoints(String sellingpoints) {
        this.sellingpoints = sellingpoints;
    }

    @Basic
    @Column(name = "houseencoding")
    public String getHouseencoding() {
        return houseencoding;
    }

    public void setHouseencoding(String houseencoding) {
        this.houseencoding = houseencoding;
    }

    @Basic
    @Column(name = "releasetime")
    public Timestamp getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Timestamp releasetime) {
        this.releasetime = releasetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseinfoEntity that = (HouseinfoEntity) o;
        return id == that.id &&
                price == that.price &&
                unitprice == that.unitprice &&
                Objects.equals(houseid, that.houseid) &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(housetype, that.housetype) &&
                Objects.equals(area, that.area) &&
                Objects.equals(previewimgurl, that.previewimgurl) &&
                Objects.equals(xiaoqu, that.xiaoqu) &&
                Objects.equals(location, that.location) &&
                Objects.equals(buildingtime, that.buildingtime) &&
                Objects.equals(buildinghead, that.buildinghead) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(downpayment, that.downpayment) &&
                Objects.equals(monthlypay, that.monthlypay) &&
                Objects.equals(decorated, that.decorated) &&
                Objects.equals(sellingpoints, that.sellingpoints) &&
                Objects.equals(houseencoding, that.houseencoding) &&
                Objects.equals(releasetime, that.releasetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, houseid, headline, price, housetype, area, previewimgurl, xiaoqu, location, buildingtime, buildinghead, floor, unitprice, downpayment, monthlypay, decorated, sellingpoints, houseencoding, releasetime);
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
}
