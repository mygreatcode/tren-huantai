package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "house", schema = "huantai", catalog = "")
public class NewHouseEntity implements  Serializable {
    private static final long serialVersionUID = -5632994218944384633L;
    private int id; //唯一id（主键）
    private String state;//房源状态 0：禁用 1：待审核 2：在线 3：已销售
    private int recommend;//标记推荐房源 0：普通 1：推荐
    private NewHouseinfoEntity newHouseinfoEntity;
    private UserinfoEntity userinfoEntity;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_HOUSE_KEY")
    public UserinfoEntity getUserinfoEntity() {
        return userinfoEntity;
    }

    public void setUserinfoEntity(UserinfoEntity userinfoEntity) {
        this.userinfoEntity = userinfoEntity;
    }

    @Basic
    @Column(name = "recommend")
    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }



    @OneToOne(mappedBy = "newHouseEntity",cascade=CascadeType.ALL)
    public NewHouseinfoEntity getNewHouseinfoEntity() {
        return newHouseinfoEntity;
    }

    public void setNewHouseinfoEntity(NewHouseinfoEntity newHouseinfoEntity) {
        this.newHouseinfoEntity = newHouseinfoEntity;
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
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
