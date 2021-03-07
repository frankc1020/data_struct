package niu.ke.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }
        Arrays.stream(arr).sorted().forEach(System.out::println);*/
        String t = in.nextLine();
        String p = in.nextLine();
        int i = t.indexOf(p);
        if(i<=0){
            System.out.println("No");
        }else{
            System.out.println(i);
        }

    }
}
