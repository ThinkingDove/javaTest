package main.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *java内置四大核心函数式接口
 *
 * 消费型Consumer<T>，有参无返，包含方法：void accept(T t);
 * 供给型Supplier<T>，无参有返，T get();
 * 函数型接口Function<T,R>,有参有返，R apply(T t);
 * 断定型接口Predicate<T>,有参返boolean，boolean test(T t);
 *
 * @author lirenxiang
 * @date 2021/7/11 15:57
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500,money -> System.out.println("买了矿泉水，花了"+money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterList = filterString(list,s -> s.contains("京"));
        System.out.println(filterList);
    }

    //根据给定的规则，过滤集合中的字符串，
    public List<String> filterString(List<String> list, Predicate<String> pre){
        List<String> filterList = new ArrayList<>();
        list.forEach(s -> {
            if(pre.test(s)){
                filterList.add(s);
            }
        });
        return filterList;
    }
}
