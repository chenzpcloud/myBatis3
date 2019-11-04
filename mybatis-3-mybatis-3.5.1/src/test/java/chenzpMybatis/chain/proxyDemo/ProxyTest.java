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
