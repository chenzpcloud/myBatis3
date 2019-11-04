package chenzpMybatis.chain.proxyDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterceptorChain {

    private List<InterceptorProxy> interceptorProxyList=new ArrayList();


    /**
     * 为目标对象添加拦截器
     * @param object
     * @return
     */
    public  Object  pluginAll(Object object){
        for (InterceptorProxy interceptor:interceptorProxyList) {
             object = interceptor.plugin(object);
        }
        return  object;
    }

    public void addInterceptor(InterceptorProxy interceptor) {
        interceptorProxyList.add(interceptor);
    }
    /**
     * 返回一个不可修改集合，只能通过addInterceptor方法添加
     * 这样控制权就在自己手里
     */
    public List<InterceptorProxy> getInterceptorList() {
        return Collections.unmodifiableList(interceptorProxyList);
    }
}
