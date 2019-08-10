package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Rentingimg", schema = "huantai", catalog = "")
public class RentingImgEntity implements Serializable {
    private int id;
    private String imgurl;
    private String type;
private RentinghouseinfoEntity rentinghouseinfoEntity;
@ManyToOne()
    public RentinghouseinfoEntity getRentinghouseinfoEntity() {
        return rentinghouseinfoEntity;
    }

    public void setRentinghouseinfoEntity(RentinghouseinfoEntity rentinghouseinfoEntity) {
        this.rentinghouseinfoEntity = rentinghouseinfoEntity;
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
@Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "imgurl")
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentingImgEntity imgEntity = (RentingImgEntity) o;
        return id == imgEntity.id &&
                Objects.equals(imgurl, imgEntity.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgurl);
    }
}
