import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        //System.out.println("Hello World!");
        Scanner scanner=new Scanner(new File(Main.class.getResource("/input.txt").toURI()));
        while (scanner.hasNextLine()){
            Node head=new Node();
            while(scanner.hasNext()){
                add(head,Integer.parseInt(scanner.next()));
            }
            // Node head= init(new int[]{1,2,3,4,5});
            print(head);
            Node newHead=reverseSingleLinklist(head);
            print(newHead);
        }
    }

    static class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node add(Node head, int e) {
        Node pre = head;
        Node cur = new Node();
        cur.value = e;
        cur.next = head.next;
        head.next = cur;
        return head;
    }

    private static Node init(int []arr){
        Node head=new Node();
        Node pre=head;
        Node cur=null;
        for(int i=0;i<arr.length;i++){
            cur=new Node();
            cur.value=arr[i];
            pre.next=cur;
            pre=cur;
        }
        return head;
    }

    private static void print(Node head){
        StringBuilder sb=new StringBuilder();
        for (Node cur = head.next; cur != null; cur = cur.next) {
            sb.append(cur.value).append(",");
        }
        System.out.println(sb.toString());
    }

    private static Node reverseSingleLinklist(Node head) {
        Node next;
        Node cur;
        cur = head.next;
        Node pre = head;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        Node newHead = new Node();
        newHead.next = pre;

        if (head.next != null) {
            head.next.next = null;
        }

        head.next = null;
        return newHead;
    }
}
