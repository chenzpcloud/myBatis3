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
