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
package chenzpMybatis.chain.proxyDemo;

import java.lang.reflect.Method;

/**
 * 对拦截对象执行信息进行封装
 */
public class InvocationProxy {

    /**
     * 目标对象
     */
    private  Object target;

    /**
     * 目标方法
     */
    private Method method;

    /**
     * 目标方法执行参数
     */
    private Object[] args;


    public InvocationProxy(Object target,Method method,Object[] args){
        this.target=target;
        this.method=method;
        this.args=args;
    }


    public  Object process() throws  Exception{
        return  method.invoke(target,args);
    }

}
