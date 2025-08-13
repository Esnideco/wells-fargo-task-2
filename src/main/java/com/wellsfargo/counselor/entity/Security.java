package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Security {

    @Id @GeneratedValue
    private Long securityId;

    @Column(nullable = false, unique = true)
    private String ticker;

    @Column(nullable = false)
    private String name;

    public Security() {}

    public Security(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;
    }

    public Long getSecurityId() {return securityId;}
    public String getTicker() {return ticker;}
    public String getName() {return name;}

    public void setTicker(String ticker) {this.ticker = ticker;}
    public void setName(String name) {this.name = name;}
}
