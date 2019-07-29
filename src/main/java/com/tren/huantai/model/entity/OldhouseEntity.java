package com.tren.huantai.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "oldhouse", schema = "houseproperty", catalog = "")
public class OldhouseEntity {
    private int id;
    private String oldhouseid;
    private String userid;
    private String state;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "oldhouseid")
    public String getOldhouseid() {
        return oldhouseid;
    }

    public void setOldhouseid(String oldhouseid) {
        this.oldhouseid = oldhouseid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldhouseEntity that = (OldhouseEntity) o;
        return id == that.id &&
                Objects.equals(oldhouseid, that.oldhouseid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oldhouseid, userid, state);
    }
}
