package com.tren.huantai.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deploy", schema = "huantai", catalog = "")
public class DeployEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "bed")
    private int hasBed;//是否有床 0没有 1有

    @Basic
    @Column(name = "broadband")
    private int hasBroadband;//是否有宽带 0没有 1有

    @Basic
    @Column(name = "air")
    private int hasAir;//是否有空调 0没有 1有

    @Basic
    @Column(name = "conditioning")
    private int hasConditioning;//是否有热水器 0没有 1有

    @Basic
    @Column(name = "washing")
    private int hasWashing;//是否有洗衣机 0没有 1有

    @Basic
    @Column(name = "tv")
    private int hasTV;//是否有电视机 0没有 1有

    @Basic
    @Column(name = "refrigerator")
    private int hasRefrigerator;//是否有电表箱 0没有 1有

    @Basic
    @Column(name = "heating")
    private int hasHeating;//是否有暖气 0没有 1有
}
