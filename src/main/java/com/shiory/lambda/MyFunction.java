package com.shiory.lambda;

/**
 * <P>
 *     自定义函数式接口
 * <P>
 *
 * @Author 汐小旅Shiory
 * @GitHub https://github.com/Shiorys
 * @Date 2019-08-18 14:53
 * @Version 1.0
 */
@FunctionalInterface
public interface MyFunction<R,T> {
    R getValue(T t);
}
