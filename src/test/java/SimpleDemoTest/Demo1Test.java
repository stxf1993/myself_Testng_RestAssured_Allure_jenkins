package SimpleDemoTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by xiaofenShentu on 2020/1/5 13:06
 */
public class Demo1Test {

    @Description("allure用例描述1")
    @Link("https://tester.com")
    @Test(description = "case1用例描述",priority = 0)
    void case1(){
        System.out.println("case1,Success"+System.currentTimeMillis());
    }

    @Test
    void case2() throws FileNotFoundException {
        System.out.println("case2,Success"+System.currentTimeMillis());
        String path=System.getProperty("user.dir")+"/src/main/resources/pikaqiu.jpg";
        System.out.println(path);
     Allure.addAttachment("pikaqiu","png/jpg",new FileInputStream(path),"jpg");
    }

    @Test
    void case3(){
        System.out.println("CASE3");
        Assert.fail("case3,fail+System.currentTimeMillis() ");
    }

    @Test(dependsOnMethods = "case3")
    void case4(){

        System.out.println("case4+System.currentTimeMillis()");
    }

}
