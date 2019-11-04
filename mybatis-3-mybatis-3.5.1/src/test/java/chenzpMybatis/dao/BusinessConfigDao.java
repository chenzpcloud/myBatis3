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
