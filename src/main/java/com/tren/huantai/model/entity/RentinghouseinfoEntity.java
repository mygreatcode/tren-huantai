package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rentinghouseinfo", schema = "houseproperty", catalog = "")
public class RentinghouseinfoEntity implements Serializable {
    private int id;
    private String headline;//标题
    private Integer price;//价格
    private String payway;//支付方式 (押一付三)
    private String area;//面积
    private String housestructure;//房屋结构
    private String locationid;//位置编号
    private String floor;//楼层
    private String decorated;//装修详细信息
    private String buildinghead;//房屋朝向
    private String housecode;//房屋编号
    private DeployEntity deployEntity;//房屋配套 （床、宽带、空调、热水器、洗衣机、电视、冰箱、暖气）
    private String describe;//租房详细描述 （无中介费，光线明亮，家具家电齐全，配有300M光纤）
    private String tag;
    private Set<RentingImgEntity> rentingImgEntity;
    private LocationEntity locationEntity;
    private  HouseStructureEntity houseStructureEntity;
    private RentinghouseEntity rentinghouseEntity;
    private String rentingpoint;
    @Basic
    @Column(name = "rentingpoint")
    public String getRentingpoint() {
        return rentingpoint;
    }

    public void setRentingpoint(String rentingpoint) {
        this.rentingpoint = rentingpoint;
    }

    @JoinColumn(name = "RENTING_HOUSE_INFO_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public RentinghouseEntity getRentinghouseEntity() {
        return rentinghouseEntity;
    }

    public void setRentinghouseEntity(RentinghouseEntity rentinghouseEntity) {
        this.rentinghouseEntity = rentinghouseEntity;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @JoinColumn(name = "RENTING_HOUSE_STRUCTURE",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public HouseStructureEntity getHouseStructureEntity() {
        return houseStructureEntity;
    }

    public void setHouseStructureEntity(HouseStructureEntity houseStructureEntity) {
        this.houseStructureEntity = houseStructureEntity;
    }

    @OneToMany(cascade=CascadeType.ALL,targetEntity=RentingImgEntity.class)
    @JoinColumn(name="RENTING_IMG_ID" )
    public Set<RentingImgEntity> getRentingImgEntity() {
        return rentingImgEntity;
    }

    public void setRentingImgEntity(Set<RentingImgEntity> rentingImgEntity) {
        this.rentingImgEntity = rentingImgEntity;
    }

    @JoinColumn(name = "RENTINGHOUSE_DEPLOY_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public DeployEntity getDeployEntity() {
        return deployEntity;
    }

    public void setDeployEntity(DeployEntity deployEntity) {
        this.deployEntity = deployEntity;
    }

    @OneToOne(mappedBy = "rentinghouseinfoEntity" ,cascade=CascadeType.ALL)
    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
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
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
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
    @Column(name = "described")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentinghouseinfoEntity that = (RentinghouseinfoEntity) o;
        return id == that.id &&
                locationid == that.locationid &&
                Objects.equals(headline, that.headline) &&

                Objects.equals(price, that.price) &&
                Objects.equals(payway, that.payway) &&
                Objects.equals(area, that.area) &&
                Objects.equals(housestructure, that.housestructure) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(decorated, that.decorated) &&
                Objects.equals(buildinghead, that.buildinghead) &&
                Objects.equals(housecode, that.housecode) &&

                Objects.equals(describe, that.describe) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headline, price, payway, area, housestructure, locationid, floor, decorated, buildinghead, housecode, describe);
    }
}
