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
package chenzpMybatis.junitTest;


import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test(timeout = 10)
    public void test1(){
        Assert.assertEquals(1,1);
           //Assert.fail("fail");

        //对控制台的输出进行部分匹配断言
       // assertThat(log.getLog(), containsString("Hello"));
    }

}
