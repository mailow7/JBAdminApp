package ru.telao.jbadmin.DAO;

import javax.persistence.*;

@Entity
@Table(name = "usercomputer")
public class UserComputer {

    @Id
    @GeneratedValue()
    @Column
    private int id;

    @Column
    private String computername;

    @Override
    public String toString() {
        return "UserComputer{" +
                "id=" + id +
                ", computername='" + computername + '\'' +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputername() {
        return computername;
    }

    public void setComputername(String computername) {
        this.computername = computername;
    }

}
