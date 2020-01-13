package com.wj.MAC_Query.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class macAddr {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(unique = true, nullable = false)
    private String macaddr;
    @Column(nullable = false)
    private String manu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMacaddr(String mac) {
        return macaddr;
    }

    public void setMacaddr(String macaddress) {
        this.macaddr = macaddress;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }
}
