package chenzpMybatis.BaseTest.myproxy;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * 查询接口
 *
 */
public interface MyQueryInterface {

    @Select("select * from business_config")
    public void  queryAll();

    @Delete("delete * from business_config")
    public void  queryAll001();
}
