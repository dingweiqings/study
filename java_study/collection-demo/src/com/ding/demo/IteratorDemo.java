package com.ding.demo;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class IteratorDemo {
    //并发访问错误，只是尽可能做到fail-fast
    //多线程访问或者单线程迭代时，调用集合的remove方法

    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        Iterator<Integer> it=list.iterator();
//        while(it.hasNext()){
//            Integer tmp=null;
//            System.out.println(tmp=it.next());
//            if((tmp & 2) ==0){
//              //  it.remove();
//                list.remove(tmp);
//            }
//        }
//        System.out.println(list.size());

//        TreeMap<Integer,Integer> map=new TreeMap<>();
//        map.put(null,1);
//        int x=1<<30;
//        int y=1<<29;
//        System.out.println(x*-1+y*-1);
//        int x=Integer.MAX_VALUE;
//        System.out.println((-1) <<1);
//        System.out.println((-x) -2);
//        System.out.println(-1 >> 4);
//         int res= coinChange(new int[]{5,2,1},100);
//         System.out.println(res);
//         long f=1L<<23;
//         long d=1L<<52;
//         System.out.println("Float :"+f+" length:"+Long.toString(f).length());
//         System.out.println("Double :"+d+" length: "+Long.toString(d).length());
//         System.out.println(-8>>3);
        int [] arr={1,2,3,4,5};
        swap(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int [] arr,int i,int j){
        arr[i]=arr[i] ^ arr[j];
        arr[j]=arr[i] ^ arr[j];
        arr[i]=arr[i] ^ arr[j];
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        //因为计算最小值，所以二维数组中的每个值都初始化为amount + 1;
        //base case
        dp[0]=0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //每个硬币可以选择多次
                if (coins[i] <= j)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static int coinChangeB1(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //因为计算最小值，所以二维数组中的每个值都初始化为amount + 1;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        //base case
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
        System.out.println("Print array");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //每个硬币可以选择多次
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //因为计算最小值，所以二维数组中的每个值都初始化为amount + 1;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        //base case
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
        System.out.println("Print array");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //每个硬币可以选择多次
                int cur=amount+1;
                for (int k = j / coins[i - 1]; k >= 0; k--) {
                    cur=Math.min(Math.min(dp[i-1][j], dp[i - 1][j - coins[i - 1] * k] + k),cur);
                }
                dp[i][j]=cur;
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }
    public static void printArray(int[][] dp,int i,int j){
        System.out.println("Print array i:"+i+" j:"+j);
        for (int ii = 0; ii < dp.length; ii++) {
            System.out.println(Arrays.toString(dp[ii]));
        }
    }
}
