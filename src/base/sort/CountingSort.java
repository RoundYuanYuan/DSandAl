package base.sort;

import base.sort.utils.Common;
import base.sort.utils.JudgeSort;
import base.sort.utils.SortContainer;

/**
 * @program: LeetCode
 * @description: 计数排序
 * @author: Mr.Zhangmy
 * @create: 2020-08-04 17:11
 * 1、选出array数组中的最大值 max ，创建 max+1 大的数组 countArray
 * 2、迭代数组array ， 将 array[i] 值的个数 写入 countArray[array[i]]
 * 3、迭代输出 aountArray的值
 **/
public class CountingSort extends SortContainer {

    @Override
    public void sort(int[] array) {
        if (array==null||array.length<2){
            return;
        }
        countingSort(array);
    }
    public static void countingSort(int array[]){
        int maxValue = getMaxValue(array);
        int countArray[]=new int[maxValue+1];
        for (int i=0;i<array.length;i++){
            countArray[array[i]]++;
        }
        int index=0;
        for (int i=0;i<countArray.length;i++){
            while (countArray[i]!=0){
                array[index++]=i;
                countArray[i]--;
            }
        }
    }
    public static int getMaxValue(int array[]){
        int max=array[0];
        int len=array.length;
        for (int i=1;i<len;i++){
            max=array[i]>max?array[i]:max;
        }
        return max;
    }

    public static void main(String[] args) {
        CountingSort  countingSort= new CountingSort();
        JudgeSort judgeSort = new JudgeSort();
        for (int i=0;i<1000;i++){
            judgeSort.isCorrect(countingSort);
        }
    }
}
