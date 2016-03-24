package org.sort;

import java.util.Arrays;

/**
 * Created by wangwr on 2016.3.22.
 */
public class SortAlgorithm {

    /**
     * 直接插入排序，时间复杂度N^2
     * @param arr
     */
    public static void insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];//取出来
            for(int j=i-1;j>=0;j--){ //依次从右往左进行对比
                if(temp<arr[j]){ //比自己大的往后移位
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
                break;
            }
            print(arr);
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        int gap = arr.length/2;//增量
        for( ; gap>0; gap /= 2){
            //分组
            print(String.format("gap:%s ",gap));
            for(int i=0;i+gap<arr.length;i++){
                //对每组进行直接插入排序
                print(String.format("%s------------------------%s",arr[i],arr[i+gap]));
                for(int j=i;j<gap+i;j++){
                    int temp = arr[j+1];
                    for(int k=j;k>=i;k--){
                        if(temp<arr[j]){
                            arr[k+1] = arr[k];
                            arr[k] = temp;
                        }
                        break;
                    }
                    print(arr);
                }
            }
        }
    }

    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args){

        int[] sort = new int[]{1,5,2,6,3,7,8,5,2};

        print("原数：");
        //insertSort(sort);

        shellSort(sort);

    }
}
