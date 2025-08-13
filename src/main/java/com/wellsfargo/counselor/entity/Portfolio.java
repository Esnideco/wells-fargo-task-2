package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id @GeneratedValue
    private Long portfolioId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate createdOn;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holding> holding = new ArrayList<>();

    public Portfolio() {}

    public Portfolio(String name, LocalDate createdOn, Client client) {
        this.name = name;
        this.createdOn = createdOn;
        this.client = client;
    }

    public Long getPortfolioId() {return portfolioId;}
    public String getName() {return name;}
    public LocalDate getCreatedOn() {return createdOn;}
    public Client getClient() {return client;}
    public List<Holding> getHolding() {return holding;}

    public void setName(String name) {this.name = name;}
    public void setCreatedOn(LocalDate createdOn) {this.createdOn = createdOn;}
    public void setClient(Client client) {this.client = client;}

    public void addHolding(Holding h) { holding.add(h); h.setPortfolio(this); }
    public void removeHolding(Holding h) {holding.remove(h); h.setPortfolio(null);}


}
