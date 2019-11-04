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
