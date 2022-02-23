package main.java4;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author lirenxiang
 * @date 2022/2/23 20:59
 */
public class OptionalTest {

    /**
     * Optional.of(T t):创建一个Optional实例，t必须非空1
     * Optional.empty()：创建一个空的Optional实例
     * Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }

}
