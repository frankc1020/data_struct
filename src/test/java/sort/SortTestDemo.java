package sort;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @title: SortTestDemo
 * @projectName base_thread
 * @description: TODO
 * @date 2021/2/22 09:55
 */
public class SortTestDemo {

    /**
     * 选择排序
     */
    public static void selectSortTest(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            //首先假设最小的下标和值
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){//当假设的的最小值大于其他值时，则进行替换
                    minIndex = j;
                    min = arr[j];
                }
            }

            if(minIndex != i){//当等于i时，则没有发生交换
                arr[minIndex] = arr[i];//首先将当前i位置的值复制到最小值得地方
                arr[i] = min;//然后将最小值复制到当前位置
            }
        }
    }


    /**
     * 插入排序
     * @param arr
     */
    public static void insertSortTest(int[] arr){
        int insertVal= 0; //定义接收插入值得变量
        int insertIndex = 0;//定义插入的地方（即数组的下标）
        for (int i = 1; i < arr.length; i++) {//循环遍历
            insertVal = arr[i];//先保存当前变量的值
            insertIndex = i-1;//在保存需要插入的下标变量

            /**
             * 给insertVal找到插入的位置
             * 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
             * 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
             * 3. 就需要将arr[insertIndex]后移
             */
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //当退出while循环时，说明插入位置找到，insertIndex + 1
            //这里我们判断是否需要赋值，如果insertIndex + 1 == i 说明该数据不需要在数组中移动位置
            if(insertIndex + 1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }

    /**
     * 希尔排序 交换法
     * @param arr
     */
    public static void shellSortTest(int[] arr){
        int temp = 0;
        for (int gap = arr.length /2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有arr.length/gap个元素），步长gap
                for (int j = i-gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }

                }
            }

        }
    }

    /**
     * 希尔排序--移位法
     * @param arr
     */
    public static void shellSortTest2(int[] arr){
        int temp = 0;
        //增量gap，并逐步的縮小增量
        for (int gap = arr.length /2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j-gap >= 0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入位置
                    arr[j] = temp;
                }

            }

        }
    }

    public static  void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r--;
            }
            if(arr[r] == pivot){
                l++;
            }

        }
        if(l==r){
            l++;
            r--;
        }
        if(left < r){
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }
    }

    public static int[] sumTwo(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] returnNum = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                returnNum[0] = map.get(arr[i]);
                returnNum[1] = i;
                break;
            }
            map.put(target-arr[i],i);
        }

        return returnNum;
    }


    public static void main(String[] args) {
        /*int[] arr = {101,34,119,1,-1,90,123};

        quickSort(arr,0,arr.length);*/
        int[] arr = {2,7,11,15,18};
        int target = 9;
        int[] num = sumTwo(arr,target);
        System.out.println(Arrays.toString(num));
    }

}
