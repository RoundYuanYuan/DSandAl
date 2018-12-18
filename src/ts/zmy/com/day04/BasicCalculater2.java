package ts.zmy.com.day04;

import java.util.Stack;

public class BasicCalculater2 {
	/**
	 * 题目：LeetCode227 利用栈做优先级 链接：
	 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
	 * 
	 * @param s
	 * @return 结果
	 */
	public static int calculate(String s) {
		int prev = 0;
		int result = 0;
		int val = 0;
		char op = '+';

		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				val = val * 10 + c - '0';
			} else if (c != ' ') {
				switch (op) {
				case '+':
					result += prev;
					prev = val;
					break;
				case '-':
					result += prev;
					prev = -val;
					break;
				case '*':
					prev = prev * val;
					break;
				case '/':
					prev = prev / val;
					break;
				}
				op = c;
				val = 0;
			}
		}

		if (op == '+') {
			prev += val;
		} else if (op == '-') {
			prev -= val;
		} else if (op == '*') {
			prev *= val;
		} else {
			prev /= val;
		}
		result += prev;
		return result;
	}



	public static void main(String[] args) {

		System.out.println(calculate(" 3+5 / 2 "));
	}
}
