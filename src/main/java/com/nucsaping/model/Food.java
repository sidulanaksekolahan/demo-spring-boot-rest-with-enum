package com.nucsaping.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pedas")
//    @Enumerated(EnumType.ORDINAL) will save in number format
    @Enumerated(EnumType.STRING)
    private Level pedas;

    public Food() {

    }

    public Food(String name, Level pedas) {
        this.name = name;
        this.pedas = pedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getPedas() {
        return pedas;
    }

    public void setPedas(Level pedas) {
        this.pedas = pedas;
    }
}
