package com.shiory.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * <P>
 *     Lambda表达式语法的简单使用
 *     使用前提：
 *          JDK版本：1.8
 *          Lambda表达式需要“函数式接口”的支持
 *          函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface 修饰，可以检查是不是函数式接口
 *     Lambda的语法包括三个部分
 *          参数列表：(参数列表)---在左侧，Lambda表达式的参数列表
 *          箭头符号："->"---也称Lambda操作符
 *          代码块：{语句体}---在右侧，Lambda 体，要执行的功能
 *     完整语法：(参数列表) -> {语句体}
 * <P>
 *
 * @Author 汐小旅Shiory
 * @GitHub https://github.com/Shiorys
 * @Date 2019-08-18 13:41
 * @Version 1.0
 */
public class Lambda01 {


    //语法格式1：无参数,无返回值,代码块只有一条语句
    //() -> 语句体
    @Test
    public void demo01(){

        //在jdk1.7及之前版本必须使用final修饰，但在jdk1.8，无需final修饰，底层已经自动加上了final，所以还是不能改变变量的值
        int num = 666;


        //使用匿名内部类的方式实现Runnable接口
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("语法格式1---匿名内部类---：num = " + num);
            }
        };
        r1.run();

        System.out.println("=====================================================");

        //使用Lambda方式实现Runnable接口
        Runnable r2 = () -> System.out.println("语法格式1---Lambda---：num = " + num);
        r2.run();
    }


    //语法格式2：有一个参数，无返回值，代码块只有一条语句
    //(x) -> 语句体
    @Test
    public void demo02(){
        //使用匿名内部类方式实现Consumer接口(JDK1.8新增接口)
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("语法格式2---匿名内部类---：参数值：" + s);
            }
        };
        con1.accept("匿名内部类");

        System.out.println("=====================================================");

        //使用Lambda方式实现Consumer接口
        Consumer<String> con2 = (x) -> System.out.println("语法格式2---Lambda---：参数值：" + x);
        con2.accept("Lambda");
    }


    //语法格式3：只有一个参数，小括号可以省略不写，无返回值，代码块只有一条语句
    // x -> 语句体
    @Test
    public void demo03(){
        //使用匿名内部类方式实现Consumer接口(JDK1.8新增接口)
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("语法格式3---匿名内部类---：参数值：" + s);
            }
        };
        con1.accept("匿名内部类");

        System.out.println("=====================================================");

        //使用Lambda方式实现Consumer接口
        Consumer<String> con2 = x -> System.out.println("语法格式3---Lambda---：参数值：" + x);
        con2.accept("Lambda");
    }


    //语法格式4：有两个以上参数，有返回值，代码块有多条语句
    // (x,y,...) -> {语句体;return 返回值;}
    @Test
    public void demo04(){
        //使用匿名内部类方式实现Comparator接口
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                System.out.print("语法格式4---匿名内部类---：参数值：x = " + x + ",y = " + y);
                return Integer.compare(x,y);
            }
        };
        int ret1 = com1.compare(6,7);
        System.out.println("，返回值：ret1 = " + ret1);

        System.out.println("=====================================================");

        //使用Lambda方式实现Comparator接口
        Comparator<Integer> com2 = (x,y) -> {
            System.out.print("语法格式4---Lambda---：参数值：x = " + x + ",y = " + y);
            return Integer.compare(x,y);
        };
        int ret2 = com2.compare(6,7);
        System.out.println("，返回值：ret2 = " + ret2);
    }


    //语法格式5：有两个以上的参数，有返回值，并且代码块只有一条语句，return和{}都可以省略不写
    // (x,y,...) -> 语句体
    @Test
    public void demo05(){
        //使用Lambda方式实现Comparator接口
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        int ret = com.compare(6,7);
        System.out.println("语法格式5---Lambda---:返回值：ret = " + ret);
    }


    //语法格式6：参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即"类型推断"
    // (Integer x,Integer y,...) -> 语句体
    @Test
    public void demo06(){
        //使用Lambda方式实现Comparator接口
        Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x,y);
        int ret = com.compare(6,7);
        System.out.println("语法格式6---Lambda---:返回值：ret = " + ret);
    }


    //使用自定义函数式接口
    @Test
    public void demo07(){
        //对一个数进行平方操作
        int ret1 = operNum(10,x -> x*x);
        System.out.println("对10进行平方操作，返回值：" + ret1);

        System.out.println("=====================================================");

        //对一个数进行加420操作
        int ret2 = operNum(100,x -> x + 420);
        System.out.println("对100进进行加420操作，返回值：" + ret2);
    }
    public Integer operNum(Integer num, MyFunction<Integer, Integer> myFunction){
        return myFunction.getValue(num);
    }
}

