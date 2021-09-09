package ru.telao.jbadmin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.telao.jbadmin.DAO.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootApplication
public class JbAdminApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JbAdminApplication.class, args);

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Product.class);
        con.addAnnotatedClass(UserLogin.class);
        con.addAnnotatedClass(UserComputer.class);
        con.addAnnotatedClass(Righttype.class);
        con.addAnnotatedClass(Rightlist.class);
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory sf = con.buildSessionFactory(sBuilder.build());

//        Product product = new Product();
//        product.setName("Clion");
//        product.setShortName("CL");
//        insertProduct(sf, product);
//
//        Product product1 = getProductbyID(sf,2);
//        System.out.println(product1);
//
//        Product p = new Product();
//        p.setName("Datagrip");
//        p.setShortName("DB");
//
//        updateProductbyID(sf,p,2);
//
//        product1 = getProductbyID(sf,2);
//        System.out.println(product1);
//
//       deleteProductbyID(sf, 1);


//        UserLogin userLogin = new UserLogin();
//        userLogin.setLogin("employee2");
//        userLogin.setUsername("emp loyee");
//        insertUserlogin(sf,userLogin);
//        UserLogin ul = getUserloginbyID(sf, 1);
//        System.out.println(ul);

//        ul.setUsername("new user");
//        updateUserlogin(sf, ul);

//        deleteUserLoginbyID(sf,6);

//        UserComputer userComputer = new UserComputer();
//        userComputer.setComputername("computer1");
//        UserLogin ul = getUserloginbyID(sf,5);
//        userComputer.setUserLogin(ul);
//
//        //insertUsercomputer(sf,userComputer);
//        UserComputer userComputer2 = getUsercomputerbyID(sf, 7);
//        System.out.println(userComputer2);

        Righttype rtype = getRighttypeidbyname(sf, "запрет");
        Product product = getProductbyID(sf, 4);
        //UserLogin userLogin = getUserloginbyID(sf,1);
        UserComputer userComputer = getUsercomputerbyID(sf,7);
        Rightlist rl = new Rightlist();
        rl.setRighttype(rtype);
        rl.setProduct(product);
        //rl.setUserLogin(userLogin);
        rl.setUserComputer(userComputer);
        insertRightlist(sf, rl);

        sf.close();


    }

    private static Righttype getRighttypeidbyname(SessionFactory sf, String name) {
        Session session = sf.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Righttype> query = builder.createQuery(Righttype.class);
        Root<Righttype> root = query.from(Righttype.class);
        query.select(root);
        query.where(builder.equal(root.get("name"), name));
        Query<Righttype> q = session.createQuery(query);
        List<Righttype> results = q.getResultList();
        session.close();
        return results.get(0);

    }

    private static Product getProductbyID(SessionFactory sf, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        transaction.commit();
        session.close();
        return product;
    }

    private static void insertRightlist(SessionFactory sf, Rightlist rightlist) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(rightlist);
        transaction.commit();
        session.close();
    }

    private static void insertProduct(SessionFactory sf, Product product) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    private static void updateProductbyID(SessionFactory sf, Product product, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        product.setId(id);
        session.update(product);
        transaction.commit();
        session.close();
    }

    private static void deleteProductbyID(SessionFactory sf, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Product p = getProductbyID(sf, id);
        session.delete(p);
        transaction.commit();
        session.close();
    }

    private static void insertUserlogin(SessionFactory sf, UserLogin userlogin) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userlogin);
        transaction.commit();
        session.close();
    }

    private static UserLogin getUserloginbyID(SessionFactory sf, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        UserLogin userLogin = session.find(UserLogin.class, id);

        transaction.commit();
        session.close();
        return userLogin;
    }

    private static void updateUserlogin(SessionFactory sf, UserLogin userLogin) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(userLogin);
        transaction.commit();
        session.close();
    }

    private static void deleteUserLoginbyID(SessionFactory sf, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        UserLogin userLogin = getUserloginbyID(sf, id);
        session.delete(userLogin);
        transaction.commit();
        session.close();
    }

    private static void insertUsercomputer(SessionFactory sf, UserComputer userComputer) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userComputer);
        transaction.commit();
        session.close();
    }

    private static UserComputer getUsercomputerbyID(SessionFactory sf, int id) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        UserComputer userComputer = session.find(UserComputer.class, id);
        transaction.commit();
        session.close();
        return userComputer;
    }


}
