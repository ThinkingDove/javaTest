package main.java2;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author lirenxiang
 * @date 2021/7/24 21:58
 *
 * 方法引用的使用
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以方法引用也是函数式接口实例
 * 3.使用格式：类（对象）::方法名
 * 4.具体以下三种情况
 *      对象::非静态方法
 *      类::静态方法
 *      类::非静态方法
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值类型相同
 */
public class MethodRefTest {

    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("************");

        Consumer<String> con2 = System.out::println;
        con2.accept("beijing");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee employee = new Employee(1001,"马化腾",34,6000.38);
        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        System.out.println("************");

        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

}
