package com.algorithm.likou.title1603;


/**
 * @author admin
 * @title: ParkingSystem
 * @projectName base_thread
 * @description: TODO
 * @date 2021/7/13 16:44
 */
public class ParkingSystem {
    int cnt; // [small medium big]
    public ParkingSystem(int _big, int _medium, int _small) {
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if (i < 10) {
                cur = (_big >> i) & 1;
            } else if (i < 20) {
                cur = (_medium >> (i - 10)) & 1;
            } else if (i < 30) {
                cur = (_small >> (i - 20)) & 1;
            }
            cnt += cur == 1 ? (1 << i) : 0;
        }
    }

    public static void main(String[] args) {
        int cnt=0;
        int _big = 100;
        int _medium = 15;
        for (int i = 0; i <10 ; i++) {
            int cur = 0;

//            int i =3;
//            int _medium = 15;
            int big = _big >> i;
//            System.out.println("i====="+i+":"+big);
            cur = big & 1;
//            System.out.println("i====="+cur);
            cnt += cur == 1 ? (1 << i) : 0;
//            System.out.println("i====="+ cnt);
            System.out.println("i====="+i+":"+big+"：cur="+ cur+"cnt:"+cnt);
        }
//        cnt |= _big;
//        System.out.println(cnt);
//        System.out.println(1<<2);
//        cnt |= (1<<2) ;
//        System.out.println(cnt);

//            cur = (_medium >> (i - 10)) & 1;
    }


    public boolean addCar(int ct) {
        int cur = countOfType(ct);
        if (cur > 0) {
            setCount(ct, cur - 1);
            return true;
        }
        return false;
    }

    int countOfType(int ct) {
        int ans = 0;
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((cnt >> i) & 1) == 1) {
                ans += (1 << (i - start));
            }
        }
        return ans;
    }

    void setCount(int ct, int pc) {
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((pc >> (i - start)) & 1) == 1) {
                cnt |= (1 << i);
            } else {
                cnt &= ~(1 << i);
            }
        }
    }
}
