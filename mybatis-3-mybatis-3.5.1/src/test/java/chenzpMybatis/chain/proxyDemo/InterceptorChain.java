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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterceptorChain {

    private List<InterceptorProxy> interceptorProxyList=new ArrayList();


    /**
     * 为目标对象添加拦截器
     * @param object
     * @return
     */
    public  Object  pluginAll(Object object){
        for (InterceptorProxy interceptor:interceptorProxyList) {
             object = interceptor.plugin(object);
        }
        return  object;
    }

    public void addInterceptor(InterceptorProxy interceptor) {
        interceptorProxyList.add(interceptor);
    }
    /**
     * 返回一个不可修改集合，只能通过addInterceptor方法添加
     * 这样控制权就在自己手里
     */
    public List<InterceptorProxy> getInterceptorList() {
        return Collections.unmodifiableList(interceptorProxyList);
    }
}
