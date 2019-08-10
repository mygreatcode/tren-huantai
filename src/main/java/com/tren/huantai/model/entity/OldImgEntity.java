package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "oldimg", schema = "huantai", catalog = "")
public class OldImgEntity implements Serializable {
    private int id;
    private String imgurl;
    private String type;
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
        OldImgEntity imgEntity = (OldImgEntity) o;
        return id == imgEntity.id &&
                Objects.equals(imgurl, imgEntity.imgurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgurl);
    }
}
