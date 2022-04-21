package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CustomerApp {
    public static void main(String[] args) {
        String conf = "resources/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(conf);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            SqlSession sqlSession = factory.openSession();
            List<Customer> list;
// insert
            Customer cc = new Customer("33", "Lily", "LA");
            sqlSession.insert("insert", cc);
// select
            list = sqlSession.selectList("selectAll");
            for (Customer c : list) {
                System.out.println(c);
            }
// select
            Customer c = sqlSession.selectOne("selectOne", "121");
            System.out.println(c);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
