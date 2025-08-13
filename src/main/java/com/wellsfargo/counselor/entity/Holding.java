package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Holding {

    @Id @GeneratedValue
    private Long holdingId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal quantity;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    public Holding () {}

    public Holding(Portfolio portfolio, Security security, BigDecimal quantity, BigDecimal purchasePrice, LocalDate purchaseDate)
    {
        this.portfolio = portfolio;
        this.security = security;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;

    }

    public Long getHoldingId() {return holdingId;}
    public Portfolio getPortfolio() {return portfolio;}
    public Security getSecurity() {return security;}
    public BigDecimal getQuantity() {return quantity;}
    public BigDecimal getPurchasePrice() {return purchasePrice;}
    public LocalDate getPurchaseDate() {return purchaseDate;}

    public void setPortfolio(Portfolio portfolio) {this.portfolio = portfolio;}
    public void setSecurity(Security security) {this.security = security;}
    public void setQuantity(BigDecimal quantity) {this.quantity = quantity;}
    public void setPurchasePrice(BigDecimal purchasePrice) {this.purchasePrice = purchasePrice;}
    public void setPurchaseDate(LocalDate purchaseDate) {this.purchaseDate = purchaseDate;}



}
