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
public class LogInterceptor implements  InterceptorProxy {

    @Override
    public Object interceptor(InvocationProxy invocationProxy) throws  Exception {
        System.out.println("日志记录");
        Object process = invocationProxy.process();
        return process;
    }

    /**
     * 执行日志操作时  插入目标对象
     * @param object
     * @return
     */
    @Override
    public Object plugin(Object object) {
        return TargetProxy.warp(object,this);
    }
}
