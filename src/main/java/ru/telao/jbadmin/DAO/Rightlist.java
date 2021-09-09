package ru.telao.jbadmin.DAO;

import javax.persistence.*;

@Entity
@Table(name = "rightlist")
public class Rightlist {
    @Id
    @GeneratedValue()
    @Column
    private int id;

    @ManyToOne
    Righttype righttype;

    @ManyToOne
    Product product;

    @ManyToOne
    UserLogin userLogin;

    @ManyToOne
    UserComputer userComputer;

    @Override
    public String toString() {
        return "Rightlist{" +
                "id=" + id +
                ", righttype=" + righttype +
                ", product=" + product +
                ", userLogin=" + userLogin +
                ", userComputer=" + userComputer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Righttype getRighttype() {
        return righttype;
    }

    public void setRighttype(Righttype righttype) {
        this.righttype = righttype;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public UserComputer getUserComputer() {
        return userComputer;
    }

    public void setUserComputer(UserComputer userComputer) {
        this.userComputer = userComputer;
    }
}
