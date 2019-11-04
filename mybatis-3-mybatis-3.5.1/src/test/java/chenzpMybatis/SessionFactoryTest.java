/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package chenzpMybatis;

import chenzpMybatis.dao.AccountDao;
import chenzpMybatis.dao.BusinessConfigDao;
import chenzpMybatis.entity.Account;
import chenzpMybatis.entity.BusinessConfigEntity;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionFactoryTest {

    public static void main(String[] args) throws  Exception{
        String resource = "sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();


        try {
            BusinessConfigDao mapper = session.getMapper(BusinessConfigDao.class);
            BusinessConfigEntity qcx_001 = mapper.selectOneEntryByCondition(new BusinessConfigEntity().setBusinessCode("qcx_001"));
            BusinessConfigEntity qcx_002 = mapper.selectOneEntryByCondition(new BusinessConfigEntity().setBusinessCode("qcx_001"));
            System.out.println(JSON.toJSONString(qcx_001));
        } finally {
            session.close();
        }

    }

    private  SqlSession sqlSession=null;

    @Before
    public void test001() throws  Exception{
        String resource = "sqlmap-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void  Test002(){
        BusinessConfigEntity qcx_001 =new BusinessConfigEntity();
        qcx_001.setBusinessCode("qcx_001");
        BusinessConfigEntity o = sqlSession.selectOne("chenzpMybatis.dao.BusinessConfigDao.selectOneEntryByCondition", qcx_001);
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void  Test003(){
        BusinessConfigDao mapper = sqlSession.getMapper(BusinessConfigDao.class);
        BusinessConfigEntity businessConfigEntity = mapper.selectBusinessConfigById(2);
        BusinessConfigEntity businessConfigEntity1 = mapper.selectBusinessConfigById(1);
        System.out.println(JSON.toJSONString(businessConfigEntity1));
    }


    @Test
    public  void  insertTest(){
        BusinessConfigEntity qcx_001 =new BusinessConfigEntity();
        qcx_001.setBusinessCode("qcx_002");
        Integer integer = sqlSession.insert("chenzpMybatis.dao.BusinessConfigDao.insertBusinessConfig", qcx_001);
        sqlSession.commit();
        System.out.println(integer);
    }

    @Test
    public  void  selectAccount(){
        Account account =new Account();
        account.setId(1);
        Account accountInfo = sqlSession.selectOne("chenzpMybatis.dao.AccountDao.selectAccoutByCondition", account);
        System.out.println(JSON.toJSONString(accountInfo));
    }

    @Test
    public  void  deleteAccount(){
        Integer o = sqlSession.delete("chenzpMybatis.dao.AccountDao.deleteAccountByid", 1);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public  void  updateAccount(){
        Account accountquery=new Account();
        accountquery.setId(3);
        Account o = sqlSession.selectOne("chenzpMybatis.dao.AccountDao.selectAccoutByCondition", accountquery);
        o.setName("abababaab");
        System.out.println(JSON.toJSONString(o));
        int update = sqlSession.update("chenzpMybatis.dao.AccountDao.updateAccountByCondition", o);
        sqlSession.commit();
        System.out.println(update);

    }

    @Test
    public  void  findColumn(){

        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Map map = mapper.selectAccountByInfo(3,"ccc");
        System.out.println(JSON.toJSONString(map));


    }


    @Test
    public  void  findAccountByids(){

        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
       List<Integer> ids =new ArrayList<>();
       ids.add(3);
       ids.add(1);
        List<Account> accounts = mapper.selectAccountByIds(ids,"czp");
        System.out.println(JSON.toJSONString(accounts));


    }



    @Test
    public  void  inserBatchtTest(){
        BusinessConfigEntity qcx_003 =new BusinessConfigEntity();
        qcx_003.setBusinessCode("qcx_003");
        BusinessConfigEntity qcx_004 =new BusinessConfigEntity();
        qcx_004.setBusinessCode("qcx_004");
        List<BusinessConfigEntity> list=new ArrayList<>();
        list.add(qcx_003);
        list.add(qcx_004);
        Integer integer = sqlSession.insert("chenzpMybatis.dao.BusinessConfigDao.insertBusinessConfigBatch", list);
        sqlSession.commit();
        System.out.println(integer);
    }


    @Test
    public void test() {
        // 带有复杂 #{} 占位符的参数，接下里会解析这个占位符
        String sql = "SELECT * FROM account WHERE id = #{id,javaType=int,jdbcType=NUMERIC}";
        SqlSourceBuilder sqlSourceBuilder = new SqlSourceBuilder(new Configuration());
        SqlSource sqlSource = sqlSourceBuilder.parse(sql, Account.class, new HashMap<>());
        BoundSql boundSql = sqlSource.getBoundSql(new Account());

        System.out.println(String.format("SQL: %s\n", boundSql.getSql()));
        System.out.println(String.format("ParameterMappings: %s", boundSql.getParameterMappings()));

    }


    @Test
    public void testMap(){
        Map haspMap=new HashMap();
        haspMap.put("k","kobe");
        Object j = haspMap.computeIfAbsent("J", k -> "JAMES");
        System.out.println(JSON.toJSONString(haspMap));
        System.out.println(JSON.toJSONString(j));

    }
}
