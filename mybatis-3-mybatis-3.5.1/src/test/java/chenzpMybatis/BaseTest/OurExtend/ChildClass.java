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
package chenzpMybatis.BaseTest.OurExtend;

public class ChildClass extends  ParentClass {

    private  String faver;

    private  String email;

    public String getFaver() {
        return faver;
    }

    public void setFaver(String faver) {
        this.faver = faver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  ChildClass (String faver, String email){
        super("chenzp","male");
        this.faver=faver;
        this.email=email;
    }


    @Override
    public String toString() {
        return "ChildClass{" +
                "faver='" + faver + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
