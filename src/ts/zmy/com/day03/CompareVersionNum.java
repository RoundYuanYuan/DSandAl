package ts.zmy.com.day03;

public class CompareVersionNum {
	/****************************************
	 * 题目要求：                             * 
	 * 比较两个版本号 version1 和 version2。   	*
	 * 如果 version1 > version2 返回 1，     	*
	 * 如果 version1 < version2 返回 -1，  	*
	 * 除此之外返回 0。                    	*
	 * **************************************
	 * @param version1						*
	 * @param version2						*
	 * @return 1  v1>v2 					*
	 * 		   -1 v1<v2						*
	 * 		   0  其他						*
	 * **************************************
	 * 示例 1:
	 * 输入: version1 = "0.1", version2 = "1.1"
	 * 输出: -1
	 * 示例 2:
	 * 输入: version1 = "1.0.1", version2 = "1"
	 * 输出: 1
	 * 示例 3:
	 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
	 * 输出: -1
	 * 
	 * 提交次数：1
	 */
	public static int compareVersion(String version1, String version2) {
		//分割v1和v2按照 .
		String[] v1Arr = version1.split("[.]");  
		String[] v2Arr = version2.split("[.]");
		//v1和v2q切割后的长度
		int v1Len = v1Arr.length;
		int v2Len = v2Arr.length;
		//v1和v2的指针
		int v1Index=0;
		int v2Index=0;
		
		
		/**
		 * 1、判断v1和v2是否都没有超出数组范围
		 * 2、判断大小
		 */
		
		while(v1Len>v1Index&&v2Len>v2Index)
		{
			int v1Num=Integer.parseInt(v1Arr[v1Index]);
			int v2Num=Integer.parseInt(v2Arr[v2Index]);
			if(v1Num>v2Num)
				return 1;
			if(v1Num<v2Num)
				return -1;
			if(v1Num==v2Num)
			{
				v1Index++;
				v2Index++;
			}
		}
		
		//v1到底后判断v2
		if(v1Len==v1Index&&v2Len!=v2Index)
		{
			int v2Num=Integer.parseInt(v2Arr[v2Index]);
			//判断v2后边的数字是否都是0(包括 “00”，“0000”)
			//是的话返回0
			//否的话返回-1
			while(v2Num==0)
			{
				v2Index++;
				if(v2Index==v2Len)
					return 0;
				v2Num=Integer.parseInt(v2Arr[v2Index]);
			}
			return -1;
		}
		//v2到底后判断v1
		if(v2Len==v2Index&&v1Len!=v1Index)
		{
			int v1Num=Integer.parseInt(v1Arr[v1Index]);
			//判断v1后边的数字是否都是0(包括 “00”，“0000”)
			//是的话返回0
			//否的话返回1
			while(v1Num==0)
			{
				v1Index++;
				if(v1Index==v1Len)
					return 0;
				v1Num=Integer.parseInt(v1Arr[v1Index]);
			}
			return 1;
		}	
		return 0;
	}
	public static void main(String[] args) {
		int compareVersion = compareVersion("1.0.1","1");
		System.out.println(compareVersion);
	}
}
