package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "houseproperty", catalog = "")
public class LocationEntity {
    private int id;
    private String loactionid;
    private double longitude;
    private double latitude;
    private String detailedaddress;

    @Id
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
