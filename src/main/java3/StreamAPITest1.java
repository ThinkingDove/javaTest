package main.java3;

import main.java2.Employee;
import main.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  测试Stream的中间操作
 *
 * @author lirenxiang
 * @date 2022-1-24 22:28:17
 */
public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list =EmployeeData.getEmployees();
//        filter(Predicate p)——接受Lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();
//        limit(n)——截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
//        skip(n)——跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
//        distinct()——筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.stream().distinct().forEach(System.out::println);






    }


}
