/*
*
 * Created by Daveola on 2/20/2015.

*/

package com.davidoladeji.exchange.model;

import javax.persistence.*;

@Entity(name = "exchangerates")
@Table(name = "exchangerates")
public class Exchange {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "symbone")
    private String symbOne;

    @Basic
    @Column(name = "symbtwo")
    private String symbTwo;


    @Basic
    @Column(name = "exchangerate")
    private double exchangerate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbOne() {
        return symbOne;
    }

    public void setSymbOne(String symbOne) {
        this.symbOne = symbOne;
    }

    public String getSymbTwo() {
        return symbTwo;
    }

    public void setSymbTwo(String symbTwo) {
        this.symbTwo = symbTwo;
    }


    public double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(double exchangerate) {
        this.exchangerate = exchangerate;
    }

}
