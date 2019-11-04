package chenzpMybatis.chain.proxyDemo;

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
