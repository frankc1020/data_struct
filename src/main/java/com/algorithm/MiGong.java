package com.algorithm;

/**
 * @author admin
 * @title: MiGong
 * @projectName base_thread
 * @description: 迷宫问题
 * @date 2020/10/13 15:46
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //0：表示未走过，1表示墙 2：通过 3：走不通
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置墙壁
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("\n\n\n走迷宫之后的路==============");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



    }

    public static  boolean setWay(int[][] arr,int i,int j){
        if(arr[6][5] == 2){
            return true;
        }else{//走法，下-》右-》上-》左

            if(arr[i][j] == 0){
                //先假设可以通过
                arr[i][j] = 2;
                if(setWay(arr,i+1,j)){//下
                    return true;
                }else if(setWay(arr,i,j+1)){//右
                    return true;
                }else  if(setWay(arr,i-1,j)){//上
                    return true;
                }else if (setWay(arr,i,j-1)) {//左
                    return true;
                }else {////说明该点是走不通，是死路
                    arr[i][j] = 3;
                    return false;
                }
            }else {//这时就是1，2，3
                return false;
            }

        }
    }

}
