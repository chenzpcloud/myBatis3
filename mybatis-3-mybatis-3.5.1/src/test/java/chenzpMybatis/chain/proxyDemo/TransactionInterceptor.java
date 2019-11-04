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

import chenzpMybatis.chain.proxyDemo.annotation.InterceptroAnnot;

@InterceptroAnnot("logInterceptor")
public class TransactionInterceptor implements  InterceptorProxy {


    @Override
    public Object interceptor(InvocationProxy invocationProxy) throws Exception {
        Object process = invocationProxy.process();
        System.out.println("事务提交");
        return process;
    }

    @Override
    public Object plugin(Object object) {
        return TargetProxy.warp(object,this);
    }
}
