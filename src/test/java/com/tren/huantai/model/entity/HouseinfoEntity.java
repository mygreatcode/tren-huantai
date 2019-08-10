package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "houseinfo", schema = "huantai", catalog = "")
public class HouseinfoEntity  implements Serializable {
    private int id;
    private String houseid;
    private String headline;
    private int price;
    private int unitprice;
    private String housetype;
    private String area;
    private String imgid;
    private String locationid;
    private Date buildingtime;
    private String buildinghead;
    private String floor;
    private String downpayment;
    private String monthlypay;
    private String decorated;
    private String sellingpoints;
    private String houseencoding;
    private Timestamp releasetime;
    private HouseEntity houseEntity;
    private Set<ImgEntity> imgEntity;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=ImgEntity.class)
    @JoinColumn(name="IMG_ID")
    public Set<ImgEntity> getImgEntity() {
        return imgEntity;
    }

    public void setImgEntity(Set<ImgEntity> imgEntity) {
        this.imgEntity = imgEntity;
    }

    @JoinColumn(name = "HOUSE_INFO_KEY",unique = true)
    @OneToOne(fetch =FetchType.LAZY)
    public HouseEntity getHouseEntity() {
        return houseEntity;
    }

    public void setHouseEntity(HouseEntity houseEntity) {
        this.houseEntity = houseEntity;
    }
   @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "unitprice")
    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
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



}
