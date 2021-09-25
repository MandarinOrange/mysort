package com.istars;

//选择排序
public class SelectionSort {
    public int[] selectionSort(int[] arr){
        for(int i=0;i < arr.length;i++){
            int minPos = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[minPos]){
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,1,2,4,7,9,8};
        SelectionSort sSort = new SelectionSort();
        int[] result = sSort.selectionSort(arr);
        for (int num : result){
            System.out.print(num+",");
        }
    }

}
