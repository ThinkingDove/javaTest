import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式的使用
 * 1、举例：（o1,o2）->Integer.compare(o1,o2);
 * 2.格式
 *        -> :lambda操作符或 箭头操作符
 *        -> 左边:lambda形参列表（接口抽象方法形参列表）
 *        -> 右边：lambda体（重写的抽象方法的方法体）
 *
 * 3、lambda表达式使用（6种情况介绍）
 * 4、lambda表达式本质：作为函数式接口的实例
 * 5、如果一个接口中，只声明了一个抽象方法，则此方法就称为函数式接口。可以再接口上添加@FunctionalInterface注解，检查是否是函数式接口
 * 6、所以以前的匿名内部类可以用lambda表达式写
 * @author lirenxiang
 * @date 2021/5/16 15:44
 */
public class LambdaTest {
    //格式一，无参，无返回值
    @Test
    public void test(){
        Runnable r1 = () -> System.out.println("我爱北京天安门");
        r1.run();
    }

    //格式二，一个参数，没有返回值
    @Test
    public void test2(){
        Consumer<String> con = (String s) -> {System.out.println(s);};
        con.accept("这是第二种情况");
    }

    //格式三，数据类型可以省略，可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con3 = (s) -> {System.out.println(s);};
        con3.accept("这是第三种情况");
    }

    //格式四，只需要一个参数，参数小括号也可以省略
    @Test
    public void test4(){
        Consumer<String> con4 = s -> {System.out.println(s);};
        con4.accept("这是第四种情况");
    }

    //格式五，需要两个或以上参数，多条执行语句，可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com5 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com5.compare(12,6));
    }

    //格式六，只有一条语句，return和{}可以省略
    @Test
    public void test6(){
        Comparator<Integer> com6 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com6.compare(12,55));
    }


}
