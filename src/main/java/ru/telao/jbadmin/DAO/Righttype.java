package ru.telao.jbadmin.DAO;

import org.hibernate.query.criteria.internal.CriteriaQueryImpl;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

@Entity
@Table(name = "righttype")
public class Righttype {

    @Id
    @GeneratedValue()
    @Column
    private int id;

    @Column
    private String name;

    @Override
    public String toString() {
        return "Righttype{" +
                "id=" + id +
                ", name=" + name +
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


}
