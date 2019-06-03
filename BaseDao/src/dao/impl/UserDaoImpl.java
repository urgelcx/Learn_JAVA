package dao.impl;

import base.impl.BaseDaoImpl;
import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

//    //连接
//    private Connection conn = DruidUtil.getConnection();
//
//    private QueryRunner qr = new QueryRunner();
//    @Override
//    public List<User> findAll() throws SQLException {
//        String sql = "SELECT * FROM user";
//        List<User> list = qr.query(conn,sql,new BeanListHandler<>(User.class));
//        System.out.println(list);
//        return list;
//    }
//
//    @Override
//    public User findById(int id) throws SQLException {
//        String sql = "SELECT * FROM user where user_id=?";
//        User user = qr.query(conn,sql,new BeanHandler<>(User.class),new Object[]{id});
//        System.out.println(user);
//        return user;
//    }
//
//    @Override
//    public int Add(User user) throws SQLException {
//        String sql = "insert into user values(?,?,?)";
//        int result = qr.update(conn,sql,new Object[]{user.getUser_id(),user.getUser_name(),user.getUser_pwd()});
//        return result;
//    }
//
//    @Override
//    public int delete(int id) throws SQLException {
//        String sql = "delete from user where user_id=?";
//        int result = qr.update(conn,sql,new Object[]{id});
//        return result;
//    }
//
//    @Override
//    public int update(User user) throws SQLException {
//        String sql = "update user set user_name=?,user_pwd = ? where user_id=?";
//        int result = qr.update(conn,sql,new Object[]{user.getUser_name(),user.getUser_pwd(),user.getUser_id()});
//        return result;
//    }
}
