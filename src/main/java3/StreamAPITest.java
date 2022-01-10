package main.java3;

import main.java2.Employee;
import main.java2.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1、Stream关注的是对数据的运算，与cpu打交道
 *   集合关注的是数据的存储，与内存打交道
 *
 * 2、
 *  Stream自己不会存储元素
 *  Stream不会改变源数据，相反，会返回一个持有新结果的新Stream
 *  Stream操作是延迟执行的，意味着等到需要结果的时候才执行
 *
 * 3、Stream的执行流程
 *  Stream的实例化
 *  一系列的中间操作（过滤，映射……）
 *  终止操作
 *
 *  测试Stream的实例化
 *
 * @author lirenxiang
 * @date 2022/1/6 22:22
 */
public class StreamAPITest {

    //创建Stream的方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
//        default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
//        default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建Stream的方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
//        调用Arrays类的static <T> Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream的方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream的方式四：创建无限流
    @Test
    public void test4() {
//        迭代
//        public static <T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);

//        生成
//        public static <T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
