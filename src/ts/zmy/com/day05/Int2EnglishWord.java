package ts.zmy.com.day05;

import java.util.HashMap;
import java.util.Map;
/**
 * 题目要求：
 * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five 
 * 		 Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 注意：空格问题
 * 		0的问题
 * 		
 * 		HashMap的读取效率是比数组差的
 * 		HashMap底层维护了一个数组
 * @author user
 *
 */
class Int2EnglishWord {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String res = "";
		int threeDigitWords = 0;
		int h = 0;
		while (num != 0) {
			threeDigitWords = num % 1000;
			num = num / 1000;
			if (threeDigitWords > 0) {
				res = threeNumberToWords(threeDigitWords) + " " + getNum(h) + " " + res.trim();
			}
			h = h + 1000;
		}
		return res.trim();
	}

	public static String threeNumberToWords(int num) {
		StringBuilder builder = new StringBuilder();
		int[] singNum = toSingNum(num);
		if (singNum[0] != 0) {
			builder.append(getNum(singNum[0]) + " " + "Hundred");
			if (singNum[1] != 0) {
				if (singNum[1] < 2 || singNum[2] == 0) {
					builder.append(" " + getNum(singNum[1] * 10 + singNum[2]));
				} else {
					builder.append(" " + getNum(singNum[1] * 10) + " " + getNum(singNum[2]));
				}
			} else {
				if (singNum[2] != 0)
					builder.append(" " + getNum(singNum[2]));
			}
		} else {
			if (singNum[1] < 2 || singNum[2] == 0) {
				builder.append(" " + getNum(singNum[1] * 10 + singNum[2]));
			} else {
				builder.append(" " + getNum(singNum[1] * 10) + " " + getNum(singNum[2]));
			}
		}
		return builder.toString();
	}

	private static int[] toSingNum(int num) {
		int digit[] = new int[3];
		int digitNum = 100;
		int i = 0;
		while (digitNum != 0) {
			digit[i++] = num / digitNum;
			num = num % digitNum;
			digitNum /= 10;
		}
		return digit;
	}

	public static String getNum(int num) {
		Map<Integer, String> Integer2Englis = new HashMap<Integer, String>();
		Integer2Englis.put(1, "One");
		Integer2Englis.put(2, "Two");
		Integer2Englis.put(3, "Three");
		Integer2Englis.put(4, "Four");
		Integer2Englis.put(5, "Five");
		Integer2Englis.put(6, "Six");
		Integer2Englis.put(7, "Seven");
		Integer2Englis.put(8, "Eight");
		Integer2Englis.put(9, "Nine");
		Integer2Englis.put(10, "Ten");
		Integer2Englis.put(11, "Eleven");
		Integer2Englis.put(12, "Twelve");
		Integer2Englis.put(13, "Thirteen");
		Integer2Englis.put(14, "Fourteen");
		Integer2Englis.put(15, "Fifteen");
		Integer2Englis.put(16, "Sixteen");
		Integer2Englis.put(17, "Seventeen");
		Integer2Englis.put(18, "Eighteen");
		Integer2Englis.put(19, "Nineteen");
		Integer2Englis.put(20, "Twenty");
		Integer2Englis.put(30, "Thirty");
		Integer2Englis.put(40, "Forty");
		Integer2Englis.put(50, "Fifty");
		Integer2Englis.put(60, "Sixty");
		Integer2Englis.put(70, "Seventy");
		Integer2Englis.put(80, "Eighty");
		Integer2Englis.put(90, "Ninety");
		Integer2Englis.put(0, "");
		Integer2Englis.put(1000, "Thousand");
		Integer2Englis.put(2000, "Million");
		Integer2Englis.put(3000, "Billion");
		return Integer2Englis.get(num);
	}
}
