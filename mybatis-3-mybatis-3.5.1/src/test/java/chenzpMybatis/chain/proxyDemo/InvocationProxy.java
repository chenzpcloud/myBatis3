package chenzpMybatis.chain.proxyDemo;

import java.lang.reflect.Method;

/**
 * 对拦截对象执行信息进行封装
 */
public class InvocationProxy {

    /**
     * 目标对象
     */
    private  Object target;

    /**
     * 目标方法
     */
    private Method method;

    /**
     * 目标方法执行参数
     */
    private Object[] args;


    public InvocationProxy(Object target,Method method,Object[] args){
        this.target=target;
        this.method=method;
        this.args=args;
    }


    public  Object process() throws  Exception{
        return  method.invoke(target,args);
    }

}
