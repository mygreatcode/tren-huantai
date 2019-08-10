package com.tren.huantai.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "newhouseinfo", schema = "huantai", catalog = "")
@ToString
@EqualsAndHashCode()
@Transactional
public class NewHouseinfoEntity implements Serializable{
    private static final long serialVersionUID = -726215690516167182L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "headline")
    private String headline;//标题

    @Basic
    @Column(name = "price")
    private int price;//价格

    @Basic
    @Column(name = "housetype")
    private String housetype;//房屋类型 （住房/商铺）

    @Basic
    @Column(name = "area")
    private String area;//面积

    @Basic
    @Column(name = "locationid")
    private String locationid;

    @Basic
    @Column(name = "buildingtime")
    private Date buildingtime;//建筑时间

    @Basic
    @Column(name = "buildinghead")
    private String buildinghead;//朝向

    @Basic
    @Column(name = "floor")
    private String floor;//楼层

    @Basic
    @Column(name = "downpayment")
    private String downpayment;//最低首付 （别墅 119.4 万（首付比例：30%））

    @Basic
    @Column(name = "monthlypay")
    private String monthlypay;//月供 （别墅 14786.05元 （按最低首付，20年等额本息））

    @Basic
    @Column(name = "decorated")
    private String decorated;//装修 （毛坯）

    @Basic
    @Column(name = "sellingpoints")
    private String sellingpoints;//卖点

    @Basic
    @Column(name = "houseencoding")
    private String houseencoding;//房屋编号

    @Basic
    @Column(name = "releasetime")
    private Timestamp releasetime; //发布时间

    @Basic
    @Column(name = "chanquannianxian")
    private String chanquannianxian;//产权年限

    @Basic
    @Column(name = "tag")
    private String tag;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,targetEntity=NewImgEntity.class)
    @JoinColumn(name="IMG_ID")
    private List<NewImgEntity> imgEntity;

    @JoinColumn(name = "HOUSE_INFO_KEY",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    private NewHouseEntity newHouseEntity;



    @OneToOne(mappedBy = "newHouseinfoEntity" ,cascade=CascadeType.ALL)
    private LocationEntity locationEntity;

    @JoinColumn(name = "HOUSE_STRUCTURE",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
    private  HouseStructureEntity houseStructureEntity;





}
