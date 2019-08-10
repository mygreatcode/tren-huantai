package com.tren.huantai.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "userinfo", schema = "huantai", catalog = "")
public class UserinfoEntity implements Serializable {
    private static final long serialVersionUID = 5222524709210387568L;
    private int id;
    private String name;
    private Date birthday;
    private byte sex;
    private String headimgpath;
    private String mobilenumber;
    private String phonenumber;
    private UserEntity userEntity;
    private Set<NewHouseEntity> newHouseEntity;
    private  Set<OldhouseEntity> oldhouseEntities;
    private List<RentinghouseEntity> rentinghouseEntities;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "userinfoEntity",targetEntity =RentinghouseEntity.class , orphanRemoval = true)
    public List<RentinghouseEntity> getRentinghouseEntities() {
        return rentinghouseEntities;
    }

    public void setRentinghouseEntities(List<RentinghouseEntity> rentinghouseEntities) {
        this.rentinghouseEntities = rentinghouseEntities;
    }

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "oldhouseuserinfo", orphanRemoval = true)
    public Set<OldhouseEntity> getOldhouseEntities() {
        return oldhouseEntities;
    }

    public void setOldhouseEntities(Set<OldhouseEntity> oldhouseEntities) {
        this.oldhouseEntities = oldhouseEntities;
    }

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "userinfoEntity", orphanRemoval = true)
    public Set<NewHouseEntity> getNewHouseEntity() {
        return newHouseEntity;
    }
    public void setNewHouseEntity(Set<NewHouseEntity> newHouseEntity) {
        this.newHouseEntity = newHouseEntity;
    }

    @JoinColumn(name = "USER_INFO_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "headimg")
    public String getHeadimgpath() {
        return headimgpath;
    }

    public void setHeadimgpath(String headimgpath) {
        this.headimgpath = headimgpath;
    }

    @Basic
    @Column(name = "mobilenumber")
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Basic
    @Column(name = "phonenumber")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserinfoEntity that = (UserinfoEntity) o;
        return id == that.id &&
                sex == that.sex &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(headimgpath, that.headimgpath) &&
                Objects.equals(mobilenumber, that.mobilenumber) &&
                Objects.equals(phonenumber, that.phonenumber)
               ;
    }
public void addHouse(NewHouseEntity h){
    this.newHouseEntity.add(h);
    h.setUserinfoEntity(this);
}
    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday, sex, headimgpath, mobilenumber, phonenumber);
    }
}
