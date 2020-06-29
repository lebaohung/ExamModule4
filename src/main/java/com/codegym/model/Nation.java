package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nationId;
    private String nationName;

    public Nation() {
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
