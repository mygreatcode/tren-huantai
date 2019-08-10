package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "huantai", catalog = "")
public class LocationEntity implements Serializable {
    private static final long serialVersionUID =8016731463945116201L;
    private int id;
    private String loactionid;
    private double longitude;//经度
    private double latitude;//纬度
    private String detailedaddress;//详细地址
    private String xiaoqu;//小区
    private ScrollimgEntity scrollimgEntity;
    private NewHouseinfoEntity newHouseinfoEntity;
    private OldhouseinfoEntity oldhouseinfoEntity;
    private RentinghouseinfoEntity rentinghouseinfoEntity;



    @JoinColumn(name = "SCROLL_INFO_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public ScrollimgEntity getScrollimgEntity() {
        return scrollimgEntity;
    }

    public void setScrollimgEntity(ScrollimgEntity scrollimgEntity) {
        this.scrollimgEntity = scrollimgEntity;
    }

    @JoinColumn(name = "OLDHOUSE_LOCATION_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public OldhouseinfoEntity getOldhouseinfoEntity() {
        return oldhouseinfoEntity;
    }

    public void setOldhouseinfoEntity(OldhouseinfoEntity oldhouseinfoEntity) {
        this.oldhouseinfoEntity = oldhouseinfoEntity;
    }

    @JoinColumn(name = "RENHOUSE_LOCATION_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public RentinghouseinfoEntity getRentinghouseinfoEntity() {
        return rentinghouseinfoEntity;
    }

    public void setRentinghouseinfoEntity(RentinghouseinfoEntity rentinghouseinfoEntity) {
        this.rentinghouseinfoEntity = rentinghouseinfoEntity;
    }

    @JoinColumn(name = "HOUSE_LOCATION_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public NewHouseinfoEntity getNewHouseinfoEntity() {
        return newHouseinfoEntity;
    }

    public void setNewHouseinfoEntity(NewHouseinfoEntity newHouseinfoEntity) {
        this.newHouseinfoEntity = newHouseinfoEntity;
    }

    @Basic
    @Column(name = "xiaoqu")
    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
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
    @Column(name = "loactionid")
    public String getLoactionid() {
        return loactionid;
    }

    public void setLoactionid(String loactionid) {
        this.loactionid = loactionid;
    }

    @Basic
    @Column(name = "longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "detailedaddress")
    public String getDetailedaddress() {
        return detailedaddress;
    }

    public void setDetailedaddress(String detailedaddress) {
        this.detailedaddress = detailedaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return id == that.id &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                Objects.equals(loactionid, that.loactionid) &&
                Objects.equals(detailedaddress, that.detailedaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loactionid, longitude, latitude, detailedaddress);
    }
}
