package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import pack.resource.SqlMapConfig;

public class ProductDao implements DaoInter{
      private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

      public List<ProductDto> selectDataAll() {
            SqlSession session = factory.openSession();
            List<ProductDto> list = null;

            try {
                  list = session.selectList("selectDataAll");
                  System.out.println(list);
                  //id selectDataAll를 통해 여러개 읽어옴 
            } catch (Exception e) {
                  System.out.println("selectDataAll err : " + e);
            } finally{
                  if(session != null) session.close();
            }
            return list;
      }
}
