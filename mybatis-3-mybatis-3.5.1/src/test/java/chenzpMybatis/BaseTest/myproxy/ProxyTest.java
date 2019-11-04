/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
