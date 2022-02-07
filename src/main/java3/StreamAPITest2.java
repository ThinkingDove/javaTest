package main.java3;

import main.java2.Employee;
import main.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 *  测试Stream的终止操作
 *
 * @author lirenxiang
 * @date 2022-1-24 22:28:17
 */
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        allMatch(Predicate p)——检查是否匹配所有元素。
//        练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

//        anyMatch(Predicate p)——检查是否至少匹配一个元素。
//        练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

//        noneMatch(Predicate p)——检查是否没有匹配的元素。
//        练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

//        findFirst——返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

//        findAny——返回当前流中的任意元素
        Optional<Employee> employee2 = employees.parallelStream().findAny();
        System.out.println(employee2);

    }

    //映射
    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
//        count——返回流中的元素总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

//        max(Comparator c)——返回流中的最大值
//        练习：返回最高的工资
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println(max);

//        min(Comparator c)——返回流中的最小值
//        练习：返回最低的工资
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(min);
//        forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);

        employees.forEach(System.out::println);
    }
}
