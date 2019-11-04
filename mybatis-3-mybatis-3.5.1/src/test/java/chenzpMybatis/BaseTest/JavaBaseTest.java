package chenzpMybatis.BaseTest;

import chenzpMybatis.BaseTest.OurExtend.ChildClass;
import sun.misc.Launcher;

import java.lang.reflect.Method;
import java.net.URL;

public class JavaBaseTest {

    public static void main(String[] args) {
        /*if (1==2){
            System.out.println("1");
        }else if(2==2){
            System.out.println("2");
        }else  if (3==3){
            System.out.println("3");
        }*/
      /*  ClassLoader classLoader = Launcher.class.getClassLoader();
        ClassLoader appClassLoader = Launcher.getLauncher().getClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader.getParent());
        System.out.println(System.getProperty("java.class.path"));;
*/

       /* ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootstrapLoader  = extClassloader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);
        System.out.println("the extClassloader : " + extClassloader);
        System.out.println("the appClassLoader : " + appClassLoader);


        System.out.println();
        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }


        System.out.println();
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.class.path"));*/
/*

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> aClass = systemClassLoader.loadClass("chenzpMybatis.entity.HelloWorld");
            Object o = aClass.newInstance();
            Method declaredMethod = aClass.getDeclaredMethod("testClassLoader");
            declaredMethod.invoke(o,null);

        } catch (Exception e) {
            e.printStackTrace();
        }
*/


        ChildClass c =new ChildClass("baseketball","1111@aa.com");
        System.out.println(c);
        System.out.println(c.getName()+"\n"+c.getSex());

    }
}
