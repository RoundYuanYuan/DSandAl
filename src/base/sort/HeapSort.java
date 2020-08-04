package base.sort;

import base.sort.utils.Common;
import base.sort.utils.JudgeSort;
import base.sort.utils.SortContainer;

/**
 * @program: LeetCode
 * @description: 堆排序
 * @author: Mr.Zhangmy
 * @create: 2020-07-28 16:14
 * 步骤 1、构建堆（升序 构建大根堆 降序构建小根堆）
 **/
public class HeapSort extends SortContainer {
    @Override
    public void sort(int[] array) {
        heapSort(array);
    }

    public static void buildHeap(int [] array){
        int index;
        int parent;
        for (int i=1;i<array.length;i++){
            index=i;
            parent=(i-1)/2;
            while (index>0&&array[index]>array[parent]){
                Common.swap(array,index,parent);
                index=parent;
                parent=(index-1)/2;
            }
        }
    }

    public static void heapSort(int [] array){
        if (array==null||array.length<2){
            return;
        }
        buildHeap(array);
        int size=array.length;
        Common.swap(array,0,--size);
        for (int i=0;i<array.length-1;i++) {
            heapify(array, size);
            Common.swap(array, 0, --size);
        }
    }

    public static void heapify(int [] array,int size){
        int index=0;
        int left=2*index+1;
        while (left<size){
            int largest=left+1<size&&array[left+1]>array[left]?left+1:left;
            largest = array[largest] < array[index] ? index : largest;
            if (index==largest){
                break;
            }
            Common.swap(array,index,largest);
            index=largest;
            left=index*2+1;
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        JudgeSort judgeSort = new JudgeSort();
        for (int i=0;i<1000;i++){
            judgeSort.isCorrect(heapSort);
        }

    }
}
