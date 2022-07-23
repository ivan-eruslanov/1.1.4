package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final static String sqlCommandCreate = "CREATE TABLE IF NOT EXISTS users (id bigint, " +
            "name varchar(100), lastName varchar(100), age tinyint)";
    private final static String sqlCommandAddNew = "INSERT INTO users (id, name, lastName, age) VALUES (?,?,?,?)";
    private final static String sqlCommandDrop = "DROP TABLE IF EXISTS users;";
    private final static String sqlCommandGetAll = "SELECT * FROM users";
    private final static String sqlCommandTruncate = "TRUNCATE TABLE users";
    private final static String sqlCommandDeleteWhere = "DELETE FROM users WHERE id = ";
    private static Transaction transaction = null;

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlCommandDrop).executeUpdate();
            session.createSQLQuery(sqlCommandCreate).executeUpdate();
            transaction.commit();
            System.out.println("таблица создана");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
