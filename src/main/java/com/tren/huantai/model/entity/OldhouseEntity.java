package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "oldhouse", schema = "huantai", catalog = "")
public class OldhouseEntity implements Serializable {
    private int id;
    private int recommend;
    private String state;
    private UserinfoEntity oldhouseuserinfo;
    private OldhouseinfoEntity oldhouseinfoEntity;

    @OneToOne(mappedBy = "oldhouseEntity",cascade=CascadeType.ALL)
    public OldhouseinfoEntity getOldhouseinfoEntity() {
        return oldhouseinfoEntity;
    }

    public void setOldhouseinfoEntity(OldhouseinfoEntity oldhouseinfoEntity) {
        this.oldhouseinfoEntity = oldhouseinfoEntity;
    }
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_OLDHOUSE_KEY")
    public UserinfoEntity getOldhouseuserinfo() {
        return oldhouseuserinfo;
    }

    public void setOldhouseuserinfo(UserinfoEntity oldhouseuserinfo) {
        this.oldhouseuserinfo = oldhouseuserinfo;
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
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }
}
