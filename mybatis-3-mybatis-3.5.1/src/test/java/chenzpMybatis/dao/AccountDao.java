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
package chenzpMybatis.dao;


import chenzpMybatis.entity.Account;
import chenzpMybatis.entity.BusinessConfigEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public  interface AccountDao {
    //自定义扩展

    Account selectAccoutByCondition(Account account);

     Integer deleteAccountByid(Integer id);

     Integer updateAccountByCondition(Account account);

    @Select("select * from user where ${column} = #{value}")
    Account findByColumn(@Param("column") String column, @Param("value") String value);


    Map selectAccountByInfo(@Param("id")int id , @Param("name")String name);

    List<Account> selectAccountByIds(@Param("ids") List<Integer> ids,@Param("address") String  address);
}
