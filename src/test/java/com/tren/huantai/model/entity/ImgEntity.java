package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "img", schema = "houseproperty", catalog = "")
public class ImgEntity {
    private int id;
    private String imgid;
    private String imgurl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        ImgEntity imgEntity = (ImgEntity) o;
        return id == imgEntity.id &&
                Objects.equals(imgid, imgEntity.imgid) &&
                Objects.equals(imgurl, imgEntity.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgid, imgurl);
    }
}
