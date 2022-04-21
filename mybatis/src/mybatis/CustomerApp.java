package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class CustomerApp {
    public static void main(String[] args) {
        String conf = "resources/Configuration.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(conf);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
//            SqlSession sqlSession = factory.openSession();
            SqlSession sqlSession = factory.openSession(true);    // auto commit
            List<Customer> list;
//  insert
            Customer cc = new Customer("33", "Lily", "LA");
//            sqlSession.insert("insert", cc);
//            sqlSession.commit();

//  select
            list = sqlSession.selectList("Customer.selectAll");
            for (Customer c : list) {
                System.out.println(c);
            }
//  select one
            Customer c = sqlSession.selectOne("selectOne", "121");
            System.out.println(c);
//  delete
            sqlSession.delete("delete", "33");

//  update
            Customer c2 = sqlSession.selectOne("selectOne", "121");
            c2.setAddress("korea");
//            sqlSession.update("update", c2);

//  namespace / select
            List list1 = sqlSession.selectList("Emp.selectAll");
            for (Object o : list1) {
                System.out.println(o);
            }
//  resultMap
            list = sqlSession.selectList("Customer.join");
            for (Customer c3 : list) {
                System.out.println(c3);
            }
            Customer c4 = sqlSession.selectOne("Emp.join");
            System.out.println("c4 = " + c4);

//  dynamic1
            HashMap map = new HashMap();
            map.put("fname","e");
            list = sqlSession.selectList("selectIf",map);
            for (Customer c5 : list) {
                System.out.println(c5);
            }

//  dynamic2
            map.clear();
//            map.put("deptid","60");
            map.put("job","IT_PROG");
            list = sqlSession.selectList("selectIf2",map);
            for (Customer c6 : list) {
                System.out.println(c6);
            }

//  dynamic3
            String[] dept = {"20","30","40"};
            list = sqlSession.selectList("forEach",dept);
            for (Customer c7 : list) {
                System.out.println(c7);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
