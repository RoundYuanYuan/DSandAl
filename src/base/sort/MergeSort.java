package base.sort;

import base.sort.utils.Common;
import base.sort.utils.JudgeSort;
import base.sort.utils.SortContainer;

/**
 * @program: LeetCode
 * @description: 归并排序
 * @author: Mr.Zhangmy
 * @create: 2020-07-28 20:14
 * 操作：
 * 1、切分
 * 2、合并
 *    1、建立辅助数组
 *    2、将切分好的按照大小复制到辅助数组中
 **/
public class MergeSort extends SortContainer {

    @Override
    public void sort(int[] array) {
        if (array==null||array.length<2){
            return;
        }
        mergeSort(array,0,array.length-1);
    }

    public static void mergeSort(int array[],int left,int right){
        if (left==right){
            return;
        }
            int mid=left+((right-left)>>1);
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            compact(array,left,mid,right);
    }

    public static void compact(int array[],int left,int mid,int right){
        int p1=left;
        int p2=mid+1;
        int help[]=new int[right-left+1];
        int helpindex=0;
        while (p1<=mid&&p2<=right){
            help[helpindex++]=array[p1]<array[p2]?array[p1++]:array[p2++];
        }
        while (p1<=mid){
            help[helpindex++]=array[p1++];
        }
        while (p2<=right){
            help[helpindex++]=array[p2++];
        }

        for(int j=0;j<help.length;j++){
            array[left+j]=help[j];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        JudgeSort judgeSort = new JudgeSort();
        for (int i=0;i<1000;i++){
            judgeSort.isCorrect(mergeSort);
        }
    }
}
