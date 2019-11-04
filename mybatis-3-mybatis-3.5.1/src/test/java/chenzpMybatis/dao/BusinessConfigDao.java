package chenzpMybatis.dao;


import chenzpMybatis.entity.BusinessConfigEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public  interface BusinessConfigDao{
    //自定义扩展

    BusinessConfigEntity selectOneEntryByCondition(BusinessConfigEntity t);

    @Select(" SELECT business_code as businessCode,id as id ,yn as yn FROM business_config WHERE id=#{id}")
    BusinessConfigEntity selectBusinessConfigById(int id);

    Integer insertBusinessConfig(BusinessConfigEntity businessConfigEntity);

    Integer  insertBusinessConfigBatch (@Param("list") List<BusinessConfigEntity>  list);

}
