package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "img", schema = "huantai", catalog = "")
public class ImgEntity implements Serializable {
    private int id;
    private String imgid;
    private String imgurl;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Id
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
