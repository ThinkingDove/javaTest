package main.java3;

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
 * @author lirenxiang
 * @date 2022/1/6 22:22
 */
public class StreamAPITest {
}
