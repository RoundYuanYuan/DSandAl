package ts.zmy.com.day04;

import java.util.Stack;

public class BasicCalculater2 {
	/**
	 * 题目：LeetCode227
	 * 利用栈做优先级
	 * 链接：
	 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
	 * @param s
	 * @return 结果
	 */
	public static int calculate(String s) {
		int slen = s.length();
		Stack<Integer> st1 = new Stack<Integer>();
		int num = 0;
		int res = 0;
		char op='+';
		for (int i = 0; i < slen; i++) {
			if (isNum(s.charAt(i)))//截取数字
				num = num * 10 + s.charAt(i) - '0';
			if(i==slen-1||(!isNum(s.charAt(i))&&s.charAt(i)!=' '))
			{
				if (op == '+')
					st1.push(num);
				if (op == '-')
					st1.push(-num);
				if (op == '*')
					st1.push(st1.pop()*num);
				if (op == '/')
					st1.push(st1.pop()/num);
				op=s.charAt(i);
				num=0;
			}

		}
		while (!st1.isEmpty()) {
			res = res + st1.pop();
		}
		return res;
	}

	public static boolean isNum(char c) {
		if ('0' <= c && c <= '9')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		System.out.println(calculate(" 3+5 / 2 "));
	}
}
