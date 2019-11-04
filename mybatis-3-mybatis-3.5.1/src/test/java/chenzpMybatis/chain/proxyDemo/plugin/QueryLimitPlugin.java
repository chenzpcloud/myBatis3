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
package chenzpMybatis.chain.proxyDemo.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * mybatis  分页查询插件
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class QueryLimitPlugin implements Interceptor {

    // 默认限制查询返回行数
    private int limit;
    // 数据库类型
    private String dbType;
    // 为了防止表名不冲突，起一个特殊的中间表名

    // 为了防止表名不冲突，起一个特殊的中间表名
    private static final String LIMIT_TABLE_NAME = "limit_table_name_1";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 取出被拦截对象
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);

        // 分离代理对象，从而形成多次代理
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }

        // 取出即将执行的SQL
        String sql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
        String limitSql;

        // 判断是否是MySQL数据库且SQL没有被重写过
        if ("mysql".equals(this.dbType) && sql.indexOf(LIMIT_TABLE_NAME) == -1) {
            sql = sql.trim();
            // 将参数写入SQL生成：select*from(select*from table_name) temp_table_name limit N的形式
            limitSql = "select * from ("+sql+") " + LIMIT_TABLE_NAME + " limit " + limit;
            // 重写要执行的SQL
            metaStatementHandler.setValue("delegate.boundSql.sql", limitSql);
        }
        // 调用原对象的方法，进入责任链的下一层
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 使用默认的Mybatis提供的类生成代理对象

        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
// 读取设置的limit
        String strLimit = properties.getProperty("limit","4");
        this.limit = Integer.parseInt(strLimit);
        // 读取设置的数据库类型
        this.dbType = (String)properties.getProperty("dbType", "mysql");
    }
}
