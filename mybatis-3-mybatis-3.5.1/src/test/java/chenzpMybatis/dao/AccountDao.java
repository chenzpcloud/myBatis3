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
