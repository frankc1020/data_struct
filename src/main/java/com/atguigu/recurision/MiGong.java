package com.atguigu.recurision;

import java.util.Arrays;

/**
 * @author admin
 * @title: MiGong
 * @projectName base_thread
 * @description: TODO
 * @date 2020/9/8 09:12
 */
public class MiGong {
    public static void main(String[] args) {
        //使用二维数组最为迷宫地图
        int[][] map = new  int[8][7];
        //设置地图屏障
        for(int i=0;i<=7;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for(int j=0;j<=6;j++){
            map[0][j] = 1;
            map[7][j] = 1;
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //使用递归回溯
        setWay(map,1,1);

        System.out.println("小球走过迷宫之后的路径：");
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 使用递归回溯来给小球找路
     * 说明：
     *   1.map表示地图
     *   2. i，j表示从地图的哪个位置开始出发（1，1）
     *   3.如果小球能到map[6][5] 位置，则说明通路找到
     *   4. 约定：当map[i][j] 为0表示该点没有走过，当为1表示墙，2 表示通路可以走，3 表示该点已经走过，但走不通
     *   5。在走迷宫时，确定一个策略(方法)下->右 ->上 ->左，如果该点走不通，再回溯
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){//通路已经找到
            return true;
        }else{
            if(map[i][j] == 0){//如果当前这个点还没有走过
                //先假设该条路可以走，并按照下->右->上->左
                map[i][j] = 2;
                if(setWay(map,i+1,j)){//下
                    return true;
                }else if(setWay(map,i,j+1)){//右
                    return true;
                }else if(setWay(map,i-1,j)){//上
                    return true;
                }else if(setWay(map,i,j-1)){//左
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {//如果map[i][j] != 0，可能是1，2，3
                return false;
            }
        }
    }
}
