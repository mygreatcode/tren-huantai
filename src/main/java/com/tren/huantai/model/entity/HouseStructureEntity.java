package com.tren.huantai.model.entity;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "housestructure", schema = "huantai", catalog = "")
public class HouseStructureEntity implements Serializable {
    @Id
    @Column(name = "id")
    private int id;//主键
    @Basic
    @Column(name = "bedroom")
    private int  bedroom;//几室
    @Basic
    @Column(name = "lobby")
    private int lobby;//几厅
    @Basic
    @Column(name = "toilet")
    private int toilet;//几卫
    @Basic
    @Column(name = "kitchen")
    private int kitchen;//几厨
}
