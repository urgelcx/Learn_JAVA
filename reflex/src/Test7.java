import java.lang.annotation.Annotation;

public class Test7 {
    public static void main(String[] args) {
        Class clazz = UserClass.class;
        Annotation[] an = clazz.getAnnotations();//获取全部注解

    }
}
@interface Bean{
    String table();
}
@interface Id{
    String value();
}
@interface Column{
    String value();
}

@Bean(table = "user")
class UserClass{
    @Id(value = "u_id")
    private int id;
    @Column(value = "name")
    private String name;
    @Column(value = "password")
    private String pwd;
    @Column(value = "phone")
    private String phone;
    @Column(value = "type")
    private String type;
    @Column(value = "q_email")
    private String email;
    @Column(value = "qq")
    private String qq;
}
