package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rentinghouse", schema = "huantai", catalog = "")
public class RentinghouseEntity {
    private int id;
    private String rentinghouseid;
    private String userid;
    private Integer state;
    private int recommend;
    @Basic
    @Column(name = "recommend")
    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
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
    @Column(name = "rentinghouseid")
    public String getRentinghouseid() {
        return rentinghouseid;
    }

    public void setRentinghouseid(String rentinghouseid) {
        this.rentinghouseid = rentinghouseid;
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
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentinghouseEntity that = (RentinghouseEntity) o;
        return id == that.id &&
                Objects.equals(rentinghouseid, that.rentinghouseid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentinghouseid, userid, state);
    }
}
