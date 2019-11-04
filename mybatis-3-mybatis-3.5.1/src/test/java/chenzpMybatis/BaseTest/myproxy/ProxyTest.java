package chenzpMybatis.BaseTest.myproxy;

import chenzpMybatis.entity.HelloWorld;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    public static void main(String[] args) {
        MyProxyMapperFactory myProxyMapperFactory=new MyProxyMapperFactory(MyQueryInterface.class);
        MyQueryInterface o = (MyQueryInterface)myProxyMapperFactory.newInstance();
        o.queryAll();
        o.queryAll001();
    }




    @Test
    public void  testHashCode(){

        HelloWorld h=new HelloWorld();
        System.out.println(h.hashCode());
    }


}
