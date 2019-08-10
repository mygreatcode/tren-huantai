package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "scrollimg", schema = "huantai", catalog = "")
public class ScrollimgEntity implements Serializable {
    private int id;
    private String imgpath;
    private String imgtitle;
    private String imgdetails;
    private String url;
    private LocationEntity locationEntity;
    private int state;

@Basic
@Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @OneToOne(mappedBy = "scrollimgEntity",cascade=CascadeType.ALL)
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
    @Column(name = "imgpath")
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Basic
    @Column(name = "imgtitle")
    public String getImgtitle() {
        return imgtitle;
    }

    public void setImgtitle(String imgtitle) {
        this.imgtitle = imgtitle;
    }

    @Basic
    @Column(name = "imgdetails")
    public String getImgdetails() {
        return imgdetails;
    }

    public void setImgdetails(String imgdetails) {
        this.imgdetails = imgdetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrollimgEntity that = (ScrollimgEntity) o;
        return id == that.id &&

                Objects.equals(imgpath, that.imgpath) &&
                Objects.equals(imgtitle, that.imgtitle) &&
                Objects.equals(imgdetails, that.imgdetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgpath,  imgtitle, imgdetails);
    }
}
