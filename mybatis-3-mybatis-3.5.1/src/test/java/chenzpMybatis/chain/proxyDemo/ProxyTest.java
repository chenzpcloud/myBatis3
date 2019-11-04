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

import org.junit.jupiter.api.Test;

public class ProxyTest {


    @Test
    public  void test001(){
        LoanResource loanResource = (LoanResource)TargetProxy.warp(new LoanResourceImpl(),null);
        loanResource.loanApply();
    }


    /**
     * 扩展1：
     * 扩展的方法不应在proxy方法中
     * 对拦截对象进行封装 作为拦截器的参数
     */
    @Test
    public  void test002(){
        LogInterceptor logInterceptor=new LogInterceptor();
        TransactionInterceptor transactionInterceptor=new TransactionInterceptor();
        LoanResource loanResource=new LoanResourceImpl();
         loanResource = (LoanResource)TargetProxy.warp(new LoanResourceImpl(),logInterceptor);
        loanResource = (LoanResource)TargetProxy.warp(new LoanResourceImpl(),transactionInterceptor);
        loanResource.loanApply();
    }


    /**
     * 对目标类说  只需要了解她插入了什么拦截器就好
     * 即  在拦截器中插入目标对象  修改拦截器对象
     */
    @Test
    public void test003(){

        LoanResource loanResource =new LoanResourceImpl();
        LogInterceptor logInterceptor=new LogInterceptor();
        TransactionInterceptor transactionInterceptor=new TransactionInterceptor();
        loanResource = (LoanResource)logInterceptor.plugin(loanResource);
        loanResource= (LoanResource)transactionInterceptor.plugin(loanResource);
        loanResource.loanApply();
    }

    /**
     * 添加责任链模式
     */
    @Test
    public void test004(){
        LoanResource loanResource =new LoanResourceImpl();
        LogInterceptor logInterceptor=new LogInterceptor();
        TransactionInterceptor transactionInterceptor=new TransactionInterceptor();
       InterceptorChain interceptorChain=new InterceptorChain();
       interceptorChain.addInterceptor(logInterceptor);
       interceptorChain.addInterceptor(transactionInterceptor);
        loanResource =(LoanResource) interceptorChain.pluginAll(loanResource);
        loanResource.loanApply();
    }
}
