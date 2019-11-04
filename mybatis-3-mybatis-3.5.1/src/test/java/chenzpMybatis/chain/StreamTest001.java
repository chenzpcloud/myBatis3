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
package chenzpMybatis.chain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class StreamTest001 {

    public static void main(String[] args) {


        List<PersonModel> dataPerson =    Data.getData();
        //过滤 filter
      /*  Stream<PersonModel> personModelStream = dataPerson.stream().filter(item -> !"男".equals(item.getSex()));
        List<PersonModel> collect = personModelStream.collect(toList());
        collect.stream().forEach(item-> System.out.println(item));*/

      /*  List<PersonModel> collect = dataPerson.stream().limit(3).collect(Collectors.toList());
        collect.stream().forEach(item-> System.out.println(item));*/

       /* List<PersonModel> collect = dataPerson.stream().distinct().collect(Collectors.toList());
        collect.stream().forEach(item-> System.out.println(item));*/

       /* Set<String> collect = dataPerson.stream().map(item -> item.getName()).collect(Collectors.toSet());
        collect.stream().forEach(System.out::println);*/
      /*  long count = dataPerson.stream().count();
        System.out.println(count);*/

      /*  boolean wang_si = dataPerson.stream().allMatch(item -> item.getName().equals("chenliu"));
        System.out.println(wang_si);*/


    /*    Map<String, PersonModel> collect = dataPerson.stream().collect(Collectors.toMap(PersonModel::getName, dataPersons -> dataPersons));
        collect.forEach((s, personModel) -> System.out.println(personModel));*/


     /* //  Stream.iterate(3, n->n+3).limit(10).forEach(System.out::println);
        Integer sum=Stream.of(1,2,3,4).reduce(Integer::sum).get();
        System.out.println(sum);*/

     /*   Integer integer = dataPerson.stream().map(item -> item.getAge()).reduce(Integer::sum).get();
        System.out.println(integer);*/

        Integer reduce = dataPerson.stream().map(item -> item.getAge()).reduce(10, (x, y) -> x + y);
        System.out.println(reduce);
    }
}
