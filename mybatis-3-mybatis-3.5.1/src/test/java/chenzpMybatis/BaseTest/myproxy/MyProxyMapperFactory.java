package chenzpMybatis.BaseTest.myproxy;

import java.lang.reflect.Proxy;

/**
 *
 * @param <T>
 */
public class MyProxyMapperFactory<T> {

    private  Class<T> mapperInterface;

    MyProxyMapperFactory(Class<T> mapperInterface){
        this.mapperInterface=mapperInterface;
    }

    public T newInstance(){
          MyProxyhandler myProxyhandler=new MyProxyhandler();
          T t = (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, myProxyhandler);
          return t;
    }

}
