package ru.telao.jbadmin.DAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userlogin")
public class UserLogin {

    @Id
    @GeneratedValue()
    @Column
    private int id;

    @Column
    private String login;

    @Column
    private String username;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserComputer> usercomputer = new ArrayList<UserComputer>();

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", username='" + username + '\'' +
                ", usercomputer=" + usercomputer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
