package com.kurt;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class ThreadLocalRandomDemo {
    //getProbe是获取一个探针,重复调用都是一样的
    //advanceProbe会重新生成一个probe
    //类似于seed
    public static void main(String[] args) throws Throwable {
        ThreadLocalRandom.current();
        MethodHandles.Lookup lookup=MethodHandles.privateLookupIn(ThreadLocalRandom.class,MethodHandles.lookup());
        MethodHandle handle=lookup.findStatic(ThreadLocalRandom.class,"getProbe", MethodType.methodType(int.class));
        for (int i = 0; i < 10; i++) {
            System.out.println(handle.invoke());
        }

        //getProbe
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(()->{
                ThreadLocalRandom.current();
                for (int j = 0; j < 5; j++) {
                    try {
                        System.out.println(Thread.currentThread().getId()+" "+handle.invoke());
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            thread.start();

        }
    }
    public static class MyFJ extends ForkJoinTask{
        @Override
        public Object getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(Object value) {

        }

        @Override
        protected boolean exec() {
            return false;
        }
    }
}
