package base.impl;

import annotation.Id;
import base.BaseDao;
import com.sun.xml.internal.bind.v2.model.core.ID;
import jdk.nashorn.internal.objects.annotations.Property;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.CORBA.OBJ_ADAPTER;
import util.DruidUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    //连接
    private Connection conn;

    private QueryRunner qr ;

    private Class<T> clazz;

    private String tableName;


    public BaseDaoImpl(){
        conn = DruidUtil.getConnection();
        qr = new QueryRunner();
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)type;
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
        tableName = clazz.getSimpleName();
    }
    @Override
    public List<T> findAll() throws SQLException {
        String sql = "SELECT * FROM "+tableName;
        List<T> list = qr.query(conn,sql,new BeanListHandler<>(clazz));
        System.out.println(list);
        return list;
    }

    @Override
    public T findById(int id) throws SQLException {
        String IdFieldName = null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                IdFieldName = field.getName();
            }
        }
        String sql = "SELECT * FROM "+tableName+" where "+IdFieldName+" =?";
        T entity = qr.query(conn,sql,new BeanHandler<>(clazz),new Object[]{id});
        System.out.println(entity);
        return entity;
    }

    @Override
    public int Add(T entity) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class claz = entity.getClass();
        String sql = "insert into "+tableName+" (";
        Field[] fields = claz.getDeclaredFields();
        for (int i = 0;i<fields.length;i++){
            Field field = fields[i];
            if (i!=fields.length-1){
                sql += field.getName()+",";
            }else {
                sql += field.getName()+")";
            }
        }
        sql += " values (";
        for (int i = 0;i<fields.length;i++){
            if (i!=fields.length-1){
                sql += " ?,";
            }else {
                sql += "?)";
            }
        }
        System.out.println(sql);
        Object[] objects = new Object[fields.length];
        Object FileValue =null;
        for (int i=0;i<fields.length;i++){
            Field field = fields[i];
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),claz);
            FileValue = pd.getReadMethod().invoke(entity,null);
            objects[i] = FileValue;
        }
        int result = qr.update(conn,sql,objects);
        return result;
    }

    @Override
    public int delete(int id) throws SQLException {
        String IdFieldName = null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                IdFieldName = field.getName();
            }
        }
        String sql = "delete from user where "+ IdFieldName +" =?";
        int result = qr.update(conn,sql,new Object[]{id});
        return result;
    }

    @Override
    public int update(T entity) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class claz = entity.getClass();
        StringBuilder sql = new StringBuilder("update " + tableName + " set ");
        Field[] fields = claz.getDeclaredFields();
        for (int i = 0;i<fields.length;i++){
            Field field = fields[i];
            if (!field.isAnnotationPresent(Id.class)){
                sql.append(field.getName()).append("=?,");
            }
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 1));
        sql.append(" where ");
        String IdFiledName = null;

        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                IdFiledName = field.getName();
            }
        }
        sql.append(IdFiledName).append(" =? ");
        System.out.println(sql);
        Object[] objects = new Object[fields.length];
        Object FieldValue =null;
        int j=0;//加到数组中的位置
        for (int i=0;i<fields.length;i++){
            Field field = fields[i];
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),claz);
            FieldValue = pd.getReadMethod().invoke(entity,null);
            if (!field.isAnnotationPresent(Id.class)){
                objects[j] = FieldValue;
                j++;
            }else {
                objects[fields.length-1] = FieldValue;
            }
        }
        int result = qr.update(conn, sql.toString(),objects);
        return result;


//        String sql = "update user set user_name=?,user_pwd = ? where user_id=?";
//        int result = qr.update(conn,sql,new Object[]{user.getUser_name(),user.getUser_pwd(),user.getUser_id()});
    }
}
