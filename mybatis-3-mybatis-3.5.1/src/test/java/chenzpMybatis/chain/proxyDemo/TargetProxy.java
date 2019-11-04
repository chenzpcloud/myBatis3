package chenzpMybatis.chain.proxyDemo;

import chenzpMybatis.chain.proxyDemo.annotation.InterceptroAnnot;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetProxy implements InvocationHandler {

    /**
     * 目标对象
     */
    private  Object target;


    private  InterceptorProxy interceptorProxy;

    public TargetProxy(Object target,InterceptorProxy interceptorProxy){
        this.target=target;
        this.interceptorProxy=interceptorProxy;
    }


    /**
     * 具体方法执行
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InterceptroAnnot annotation = interceptorProxy.getClass().getAnnotation(InterceptroAnnot.class);
        if (annotation!=null){
            InvocationProxy invocationProxy=new InvocationProxy(target,method,args);
            return  interceptorProxy.interceptor(invocationProxy);
        }
       return  method.invoke(target,args);

    }


    public  static Object warp(Object object,InterceptorProxy interceptorProxy){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new TargetProxy(object,interceptorProxy));
    }


}
