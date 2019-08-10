package com.tren.huantai.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "house", schema = "huantai", catalog = "")
public class HouseEntity {
    private int id;
    private String houseid;
    private String userid;
    private String state;
    private int recommend;
    private HouseinfoEntity houseinfoEntity;
    @Basic
    @Column(name = "recommend")
    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }



    @OneToOne(mappedBy = "newHouseEntity")
    public HouseinfoEntity getHouseinfoEntity() {
        return houseinfoEntity;
    }

    public void setHouseinfoEntity(HouseinfoEntity houseinfoEntity) {
        this.houseinfoEntity = houseinfoEntity;
    }
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
