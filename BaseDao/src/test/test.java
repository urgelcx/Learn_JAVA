package test;

import base.DaoFactory;
import dao.impl.UserDaoImpl;
import entity.User;


import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws SQLException, IllegalAccessException, IntrospectionException, InvocationTargetException {
//        System.out.println(new UserDaoImpl().Add(new User(7,"hl","123")));
//        System.out.println(new UserDaoImpl().update(new User(7,"hl","1234")));
//        System.out.println(new UserDaoImpl().findAll());
//        System.out.println(new UserDaoImpl().delete(7));
        System.out.println(DaoFactory.getInstance().getUserDao().findAll());
    }
}
