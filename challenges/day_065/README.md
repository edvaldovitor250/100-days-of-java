# Day 65

## Desafio:

Desenvolva um aplicativo em Java que permita ao usuário realizar consultas em um banco de dados utilizando o framework Hibernate.
    
**Resultado:**


```java

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import java.util.List;

public class Day065 {

    @Entity
    @Table(name = "user")
    public static class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        setup();

        Day065 app = new Day065();

        Integer userId1 = app.addUser("John Doe", "john.doe@example.com");
        Integer userId2 = app.addUser("Jane Smith", "jane.smith@example.com");

        app.listUsers();
        app.updateUser(userId1, "john.doe@newdomain.com");
        app.deleteUser(userId2);
        app.listUsers();

        sessionFactory.close();
    }

    public static void setup() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Integer addUser(String name, String email) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer userId = null;

        try {
            tx = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            userId = (Integer) session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }

    public void listUsers() {
        Session session = sessionFactory.openSession();
        try {
            List users = session.createQuery("FROM User").list();
            for (Object userObj : users) {
                User user = (User) userObj;
                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            }
        } finally {
            session.close();
        }
    }

    public void updateUser(Integer userId, String email) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setEmail(email);
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteUser(Integer userId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
