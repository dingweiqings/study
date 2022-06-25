package com.ding.cf;

import java.util.concurrent.CompletableFuture;

public class CFutureStudy {
    public static void main(String[] args) {
        CompletableFuture<Integer> cFuture=new CompletableFuture<>();
        cFuture.thenApply(x->x+1).thenApply(x->x+2).thenAccept(System.out::println);
        cFuture.complete(10);
        //以CompleteFuture内部的stack作为类似链表的next指针，（then apply next指针好像没用到）
        //通过thenApply连接的，当第一个Future完成时，会通过stack找到下一个节点，然后完成下一个节点，
        // 此时也是CompletableFuture complete，就会重复之前的逻辑，直到某一个CFuture的stack为空
    }
}
