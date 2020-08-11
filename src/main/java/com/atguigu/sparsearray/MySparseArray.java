package com.atguigu.sparsearray;

import java.io.*;

/**
 * @author admin
 * @title: MySparseArray
 * @projectName base_java
 * @description: 稀疏数组自己练习
 * @date 2020/7/29 11:25
 *
 * 二维数组 转 稀疏数组的思路
 * 1.遍历原始的二维数组，得到有效数据的个数 sum
 * 2.根据sum就可以创建稀疏数组sparseArray int[sum+1][3]
 * 3.将二维数组的有效数据存入到稀疏数组
 *
 * 稀疏数组转原始的二维数组的思路：
 *    1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArray2 = int[11][11];
 *    2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组
 *
 *
 *
 *  总结： 稀疏数组与二维数组的关系
 *   1. 稀疏数组第一行存储二维数组的行、列、和有效数据的个数
 *   2.稀疏数组从第二行开始存储二维数组有效值所在的行、列，有效值
 *   稀疏数组：
 *            行             列          值
 *     [0] 二维数组行数  二维数组列数       有效值个数
 *     [1] 有效值所在行   有效值所在列       有效值    稀疏数组下面数据同这一行
 *
 */
public class MySparseArray {

    public static void main(String[] args) {
        //创建原始数组并设置值
        int[][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        array1[4][5] = 2;
        //打印原始数组
        printf(array1);
        System.out.println("=========原始数组转换稀疏数组============");
        //1.首选遍历原始数组获取原始数组中实际有效的值得个数
        int sum = 0;
        for(int i=0;i<array1.length;i++){
            for(int j = 0;j<array1[i].length;j++){
                if(array1[i][j] > 0){
                    sum++;
                }
            }
        }

        //2.根据第一步获取的有效数值，创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = array1.length;
        sparseArray[0][1] = array1[0].length;
        sparseArray[0][2] = sum;

        int count = 1;
        for(int i=0;i<array1.length;i++){
            for(int j = 0;j<array1[i].length;j++){
                if(array1[i][j] > 0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array1[i][j];
                    count++;
                }
            }
        }
        //输出稀疏数组
        printf(sparseArray);

        //将稀疏数组存储到文件中
        File file = new File("/Users/guzhaocong/Documents/test/array.txt");
        try {
            FileWriter fw = new FileWriter(file);
            for(int i=0;i<sparseArray.length;i++){
                for(int j =0;j<sparseArray[0].length;j++){
                    fw.write(sparseArray[i][j]+"\t");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("文件写入异常");
        }
        //声明稀疏数组
        int[][] sparseArray2 = new int[sum+1][3];
        //从文件中将稀疏数组读取出来
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;//一行数据
            int row = 0;
            //逐行读取
            while((line = in.readLine()) != null){
                String[] temp = line.split("\t");
                for(int i=0;i<temp.length;i++){
                    sparseArray2[row][i] = Integer.parseInt(temp[i]);
                }
                row++;
            }
            in.close();
        }catch (Exception e){
            System.out.println("读取文件异常");
        }

        System.out.println("========================从文件中读取稀疏数组，打印===========================");
        printf(sparseArray2);




        //稀疏数组转换为二维数组
        //获取稀疏数组第一列初始化二维数组
        int[][] array2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        System.out.println("二维数组行数："+array2.length);
        System.out.println("二维数组列数："+array2[0].length);
        for(int i=1;i<sparseArray.length;i++){
            array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印出转换之后的二位数组
        printf(array2);

    }

    //打印原始数组
    public static  void printf(int[][] array){
        for(int[] row : array){
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

}
