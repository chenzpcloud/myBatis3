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

import chenzpMybatis.entity.BusinessConfigEntity;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

    @Test
    public void testJdbc() throws  Exception {

        String url = "jdbc:MySql://localhost:3306/our_database";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String sql="select id, business_code, business_type, config_type, config_key, config_value, comment, modify_user, yn, created_date, modified_date from business_config WHERE business_code='qcx_001' ";
        ResultSet resultSet = statement.executeQuery(sql);
        List<BusinessConfigEntity> articles = new ArrayList<BusinessConfigEntity>(resultSet.getRow());
        BusinessConfigEntity businessConfigEntity=null;
        while (resultSet.next()){
            businessConfigEntity.setBusinessCode(resultSet.getString("business_code"));
        }

        System.out.println(businessConfigEntity);

    }

    @Test
    public void testPro() throws  Exception {

       //String xmlPath="mapper/proxyMapper.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        String  mapperResource="mapper/proxyMapper.xml";
        InputStream resourceAsStream = JdbcTest.class.getClassLoader().getResourceAsStream(mapperResource);
        // File file =new File("D:\\companyProject\\workSpacce\\proxyClient\\src\\proxyMapper.xml");
        try {
            Document parse = documentBuilder.parse(resourceAsStream);
            NodeList mappers = parse.getElementsByTagName("mappers");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }


}
