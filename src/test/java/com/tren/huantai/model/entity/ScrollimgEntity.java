package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scrollimg", schema = "huantai", catalog = "")
public class ScrollimgEntity {
    private int id;
    private String imgpath;
    private int imgid;
    private String imgtitle;
    private String imgdetails;

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
    @Column(name = "imgid")
    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
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
                imgid == that.imgid &&
                Objects.equals(imgpath, that.imgpath) &&
                Objects.equals(imgtitle, that.imgtitle) &&
                Objects.equals(imgdetails, that.imgdetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgpath, imgid, imgtitle, imgdetails);
    }
}
