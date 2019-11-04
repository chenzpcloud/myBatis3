package chenzpMybatis.chain.proxyDemo;

public interface InterceptorProxy {

    Object interceptor(InvocationProxy invocationProxy) throws  Exception;

    Object plugin(Object object);
}
