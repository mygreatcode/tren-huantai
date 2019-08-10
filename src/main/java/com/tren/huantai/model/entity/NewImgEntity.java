package com.tren.huantai.model.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "newimg", schema = "huantai", catalog = "")
@ToString
@EqualsAndHashCode()
public class NewImgEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name="type")
    private String imgpath;

    @Basic
    @Column(name = "imgpath")
    private String type;


}
