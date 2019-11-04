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
