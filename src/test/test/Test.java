package test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import po.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void findUserByIdTest() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("test.findUserById",1);
        System.out.println(user);
        session.close();
    }
    @org.junit.jupiter.api.Test
    public void findUserByNameTest() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("test.findUserByName","张三");
        System.out.println(user);
        session.close();
    }
    @org.junit.jupiter.api.Test
    public void findUserByuNameTest() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<User> list = session.selectList("test.findUserByuName","三");
        System.out.println(list);
        session.close();
    }
}
