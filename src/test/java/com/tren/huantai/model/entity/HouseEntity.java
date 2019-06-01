package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house", schema = "houseproperty", catalog = "")
public class HouseEntity {
    private int id;
    private String houseid;
    private String userid;
    private String state;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "houseid")
    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
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
        HouseEntity that = (HouseEntity) o;
        return id == that.id &&
                Objects.equals(houseid, that.houseid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, houseid, userid, state);
    }
}
