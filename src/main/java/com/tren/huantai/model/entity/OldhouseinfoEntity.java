package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "oldhouseinfo", schema = "huantai", catalog = "")
public class OldhouseinfoEntity implements Serializable {
    private int id;
    private String headline;//标题
    private int price;//价格
    private String area;//面积
    private String housetype;//房屋类型 住房/商铺
    private String locationid;//位置编码
    private Date buildingtime;//建房时间
    private String buildinghead;//房屋朝向
    private String floor;//楼层
    private String sellingpoints;//卖点
    private String heatingsystem;//
    private String housenianxian;//房屋年限 （满五年）
    private String chanquannianxian;//产权年限
    private String mortgageinfo;//抵押信息
    private String havecertificate;//证件
    private String whoproperty;//产权所属
    private String deployid;//房屋配套 （床、宽带、空调、热水器、洗衣机、电视、冰箱、暖气）
    private String downpayment;//最低首付 （别墅 119.4 万（首付比例：30%））
    private String monthlypay;//月供 （别墅 14786.05元 （按最低首付，20年等额本息））
    private String tag;
    private OldhouseEntity oldhouseEntity;
    private Set<OldImgEntity>  oldimgEntity;
    private LocationEntity locationEntity;
    private DeployEntity  deployEntity;
    private  HouseStructureEntity houseStructureEntity;
@Basic
@Column(name = "sellingpoints")
    public String getSellingpoints() {
        return sellingpoints;
    }

    public void setSellingpoints(String sellingpoints) {
        this.sellingpoints = sellingpoints;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @JoinColumn(name = "OLD_HOUSE_STRUCTURE",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public HouseStructureEntity getHouseStructureEntity() {
        return houseStructureEntity;
    }

    public void setHouseStructureEntity(HouseStructureEntity houseStructureEntity) {
        this.houseStructureEntity = houseStructureEntity;
    }
    @OneToOne(mappedBy = "oldhouseinfoEntity" ,cascade=CascadeType.ALL)
    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,targetEntity=OldImgEntity.class)
    @JoinColumn(name="OLD_IMG_ID")
    public Set<OldImgEntity> getOldimgEntity() {
        return oldimgEntity;
    }

    public void setOldimgEntity(Set<OldImgEntity> oldimgEntity) {
        this.oldimgEntity = oldimgEntity;
    }

    @JoinColumn(name = "OLDHOUSE_DEPLOY_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public DeployEntity getDeployEntity() {
        return deployEntity;
    }

    public void setDeployEntity(DeployEntity deployEntity) {
        this.deployEntity = deployEntity;
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
@Column(name = "deployid")
    public String getDeployid() {
        return deployid;
    }

    public void setDeployid(String deployid) {
        this.deployid = deployid;
    }

    @JoinColumn(name = "OLDHOUSE_KEY",unique = true)
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    public OldhouseEntity getOldhouseEntity() {
        return oldhouseEntity;
    }

    public void setOldhouseEntity(OldhouseEntity oldhouseEntity) {
        this.oldhouseEntity = oldhouseEntity;
    }

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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
                Objects.equals(headline, that.headline) &&
                Objects.equals(area, that.area) &&
                Objects.equals(housetype, that.housetype) &&
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
        return Objects.hash(id,  headline, price,  area, housetype, locationid, buildingtime, buildinghead, floor, heatingsystem, housenianxian, chanquannianxian, mortgageinfo, havecertificate, whoproperty);
    }
}
