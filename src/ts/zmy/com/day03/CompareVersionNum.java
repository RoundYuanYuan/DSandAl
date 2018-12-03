package ts.zmy.com.day03;

public class CompareVersionNum {
	/****************************************
	 * 题目要求： * 比较两个版本号 version1 和 version2。 * 如果 version1 > version2 返回 1， * 如果
	 * version1 < version2 返回 -1， * 除此之外返回 0。 *
	 * **************************************
	 * 
	 * @param version1 *
	 * @param version2 *
	 * @return 1 v1>v2 * -1 v1<v2 * 0 其他 * ************************************** 示例
	 *         1: 输入: version1 = "0.1", version2 = "1.1" 输出: -1 示例 2: 输入: version1 =
	 *         "1.0.1", version2 = "1" 输出: 1 示例 3: 输入: version1 = "7.5.2.4",
	 *         version2 = "7.5.3" 输出: -1
	 * 
	 *         提交次数：3 优化性能
	 */
	public static int compareVersion(String version1, String version2) {
		// 分割v1和v2按照 .
		String[] v1Arr = version1.split("[.]");
		String[] v2Arr = version2.split("[.]");
		// v1和v2q切割后的长度
		int v1Len = v1Arr.length;
		int v2Len = v2Arr.length;
		// v1和v2的指针
		int v1Index = 0;
		int v2Index = 0;
		//讲字符窜转数字
		int v1Num = 0;
		int v2Num = 0;
		/**
		 * 1、判断v1和v2是否都没有超出数组范围 2、判断大小
		 */
		while (v1Len > v1Index && v2Len > v2Index) {
			v1Num = Integer.parseInt(v1Arr[v1Index]);
			v2Num = Integer.parseInt(v2Arr[v2Index]);
			if (v1Num > v2Num)
				return 1;
			if (v1Num < v2Num)
				return -1;
			if (v1Num == v2Num) {
				v1Index++;
				v2Index++;
			}
		}

		// v1到底后判断v2
		if (v1Len == v1Index && v2Len != v2Index)
			return isAllZero(v2Arr, v2Len, v2Index, -1);
		// v2到底后判断v1
		if (v1Len != v1Index && v2Len == v2Index)
			return isAllZero(v1Arr, v1Len, v1Index, 1);
		return 0;
	}

	/**
	 * 判断v1后边的数字是否都是0(包括 “00”，“0000”) 是的话返回0 否的话返回res
	 * 
	 * @param arr    要判断的数组
	 * @param len    数组长度
	 * @param vIndex 指针指向的位置
	 * @param res    要返回的结果
	 * @return res 同上
	 */
	public static int isAllZero(String[] arr, int len, int vIndex, int res) {
		int vNum = Integer.parseInt(arr[vIndex]);
		while (vNum == 0) {
			vIndex++;
			if (vIndex == len)
				return 0;
			vNum = Integer.parseInt(arr[vIndex]);
		}
		return res;
	}

	public static void main(String[] args) {
		int compareVersion = compareVersion("1.0.0", "2");
		System.out.println(compareVersion);
	}
}
