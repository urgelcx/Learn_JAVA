package base;

import dao.UserDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LCX
 * 工厂类：像Service层输出Dao的实现类
 *        必须是单例的
 */
public class DaoFactory {
    private static DaoFactory factory=null;

    private DaoFactory(){
        Properties prop = new Properties();
        InputStream is = DaoFactory.class.getClassLoader().getSystemResourceAsStream("daoConfig.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String UserDaoClass = prop.getProperty("UserDaoClass");
        String BookDaoClass = prop.getProperty("BookDaoClass");
        try {
            userDao = (UserDao) Class.forName(UserDaoClass).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getInstance(){
        if (factory==null){
            synchronized (DaoFactory.class){
                factory = new DaoFactory();
            }
        }
        return factory;
    }

    private static UserDao userDao=null;

    public UserDao getUserDao(){
        return userDao;
    }


}
