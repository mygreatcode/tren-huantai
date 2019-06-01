package com.tren.huantai.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HouseinfoEntityPK implements Serializable {
    private int id;
    private String houseid;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "houseid")
    @Id
    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseinfoEntityPK that = (HouseinfoEntityPK) o;
        return id == that.id &&
                Objects.equals(houseid, that.houseid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, houseid);
    }
}
