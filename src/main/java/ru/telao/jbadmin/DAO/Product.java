package ru.telao.jbadmin.DAO;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue()
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String shortName;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}