package base.sort.utils;

import base.sort.utils.SortContainer;

import java.util.Arrays;
import java.util.Random;

import static base.sort.utils.Common.printArray;

/**
 * @program: LeetCode
 * @description:
 * @author: Mr.Zhangmy
 * @create: 2020-07-28 14:34
 **/
public class JudgeSort {
    /**
     * 对数器
     * 1、随机生成数组
     * 2、使用java排序
     * 3、使用自己写的方法排序
     * 4、比较两个数组是否一样
     */
    public static Random random = new Random();
    public static int [] genArray(int len,int range){
        int [] array=new int[len];
        try {
            for (int i=0;i<len;i++){
                array[i]=random.nextInt(range);
            }
        }catch (IllegalArgumentException e){
            System.out.println(range);
            e.printStackTrace();
            System.exit(1);
        }

        return array;
    }

    public boolean equalsArray(int array1[],int array2[]){
        int len1=array1.length;
        int len2=array2.length;
        if (len1!=len2){
            return false;
        }
        for (int i=0;i<len1;i++){
            if (array1[i]!=array2[i]){
                return false;
            }
        }
        return true;
    }

    public void isCorrect(SortContainer sortContainer){
        int len=random.nextInt(20);
        int bound=1+random.nextInt(100);
        int[] array = genArray(len, bound);
        int[] array1 = array.clone();
        Arrays.sort(array);
        sortContainer.sort(array1);
        if (!equalsArray(array,array1)){
            System.out.println("未通过");
            printArray(array);
            printArray(array1);
        }
    }
}
