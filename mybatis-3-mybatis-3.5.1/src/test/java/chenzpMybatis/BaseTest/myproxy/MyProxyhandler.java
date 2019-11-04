package chenzpMybatis.BaseTest.myproxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类Handler
 */
public class MyProxyhandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName());
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        System.out.println(declaredAnnotations[0]);
        return null;
    }
}
