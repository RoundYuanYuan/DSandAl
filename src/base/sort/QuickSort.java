package base.sort;

import base.sort.utils.Common;
import base.sort.utils.JudgeSort;
import base.sort.utils.SortContainer;

/**
 * @program: LeetCode
 * @description: 快排实现
 * @author: Mr.Zhangmy
 * @create: 2020-07-28 11:38
 *
 * 实现:  1、参数校验
 *       2、分区
 *       2.1、选取基准值
 *       2.2、数字交换
 **/
public class QuickSort extends SortContainer {


    @Override
    public void sort(int[] array) {
        if (array==null||array.length<2){
            return;
        }
        quickSort(array,0,array.length-1);
    }


    public static void quickSort(int array[],int left,int right){
        if (left<right){
            int[] partion = partion(array, left, right);
            quickSort(array,left,partion[0]);
            quickSort(array,partion[1]+1,right);
        }
    }

    public static int [] partion(int array[],int left,int right){
        int less=left-1;
        int more=right;
        while (left<more){
            if (array[left]<array[right]){
                Common.swap(array,left++,++less);
            }else if (array[left]>array[right]){
                Common.swap(array,left,--more);
            }else {
                left++;
            }
        }
        Common.swap(array,more,right);
        return new int[]{less,more};
    }



    public static void main(String[] args) {
        JudgeSort utils = new JudgeSort();
        for (int i=0;i<10000;i++){
            utils.isCorrect(new QuickSort());
        }
    }
}
