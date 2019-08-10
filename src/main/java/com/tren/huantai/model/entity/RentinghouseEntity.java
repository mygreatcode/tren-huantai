package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rentinghouse", schema = "huantai", catalog = "")
public class RentinghouseEntity implements Serializable {
    private int id;
    private Integer state;//状态：0(禁用) 1（审核） 2（上线） 3（已售卖）
    private int recommend;//推荐 0:普通 1推荐
   private RentinghouseinfoEntity rentinghouseinfoEntity;
   private UserinfoEntity userinfoEntity;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_RENTINGHOUSE_KEY")
    public UserinfoEntity getUserinfoEntity() {
        return userinfoEntity;
    }

    public void setUserinfoEntity(UserinfoEntity userinfoEntity) {
        this.userinfoEntity = userinfoEntity;
    }




    @OneToOne(mappedBy = "rentinghouseEntity",cascade=CascadeType.ALL)
    public RentinghouseinfoEntity getRentinghouseinfoEntity() {
        return rentinghouseinfoEntity;
    }

    public void setRentinghouseinfoEntity(RentinghouseinfoEntity rentinghouseinfoEntity) {
        this.rentinghouseinfoEntity = rentinghouseinfoEntity;
    }

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
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,state);
    }
}
