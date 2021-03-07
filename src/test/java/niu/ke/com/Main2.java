package niu.ke.com;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        if(M<= 1 || M >=100){
            System.out.println("ERROR!");
            return;
        }
        Node first = new Node(1);
        Node temp = first;
        for (int i = 2; i < 100; i++) {
            Node next = new Node(i);
            temp.next = next;
            temp = temp.next;

        }
        Node last = new Node(100);
        temp.next = last;
        last.next = first;
        int count = 100;
        while(count >= M){
            for(int i=1;i<M;i++){
                first = first.next;
                last = last.next;
            }
            first =  first.next;
            last.next = first;
            count--;
        }
        while(first.value > first.next.value || last.value < first.value){
            first = first.next;
            last = last.next;
        }
        for (int i = 1; i < M-1; i++) {
            System.out.print(first.value+",");
            first = first.next;
        }
        System.out.println(last.value);

        in.close();

    }
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
}
