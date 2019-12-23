package com.dingweiqings.generic;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2018/9/12
 */
/**
 * 自定义泛型接口
 *
 * 接口中泛型字母只能使用在方法中，不能使用在全局常量中
 *
 * @author Administrator
 * @param <T1,T2>
 */
public interface Comparator<T1,T2> {

    public static final int MAX_VALUE = 100;

    void compare(T2 t);
    T2 compare();
    public abstract T1 compare2(T2 t);
}
