package com.ding.lockdemo.utils;

import java.util.List;

/**
 * cc.ketianyun.com copyright
 *
 * @Author kurt.ding
 * @Description
 * @Date 2019/2/3
 */
public class Utils {
    public static boolean isEmpty(List list){
        if(list==null)
            return true;
        if(list!=null&&list.size()==0)
            return true;
        return false;
    }
}
