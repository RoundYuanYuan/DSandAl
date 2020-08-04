package base.sort.utils;

/**
 * @program: LeetCode
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-07-28 16:24
 **/
public class Common {
    public static void swap(int [] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public static void printArray(int []array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");;
        }
        System.out.println();
    }
}
