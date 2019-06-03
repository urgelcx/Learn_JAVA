package base;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
   public List<T> findAll() throws SQLException;
   public T findById(int id) throws SQLException;
   public int Add(T user) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException;
   public int delete(int id) throws SQLException;
   public int update(T user) throws SQLException, IntrospectionException, InvocationTargetException, IllegalAccessException;
}
