package ts.zmy.com.day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @date 2018.11.18
 * @author user
 *  ********************************************************** 
 *  介绍：
 *  LeetCode30题：与所有单词相关联的字串 
 *  题目描述： 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可
 *           以恰好串联 words 中所有单词的子串的起始位置。
 *           注意子串要与 words 中的单词完全匹配，
 *           中间不能有其他字符，但不 需要考虑words 中单词串联的顺序。 
 *  示例： 输入:s = "barfoothefoobarman", words =["foo","bar"] 输出: [0,9]
 *  解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。输出的顺序不重要, [9,0] 也是有效答案。
 ************************************************************
 *思路：
 *将words统计放到一个map中 从s中截取子字符转判断是否相等 
 *相等：map中对应字符串 -1
 *不相等：从s的下一个字符串继续判断，初始化map 等到map为空，说明该索引是答案。
 *
 *第一次提交未优化
 */
public class LeetCode30 {
	public List<Integer> findSubstring(String s, String[] words) {
		//需要返回的结果
		ArrayList<Integer> res = new ArrayList<Integer>();
		//字符串的长度
		int sLen = s.length();
		//一共有几个单词
		int wordsLen = words.length;
		//用来指示是否匹配完
		int count = wordsLen;
		boolean countChange = false;
		if (wordsLen == 0)
			return res;
		int wordLen = words[0].length();
		int cycTime = sLen - wordsLen * wordLen;
		// 1、判断words是否符合规范
		if (cycTime < 0)
			return res;
		// 2、初始化map
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		initMap(words, map);
		int j;
		// 2、循环截取s的子字符串
		for (int i = 0; i <= cycTime; i++) {
			String substring = s.substring(i, i + wordLen);
			j = i;
			while (map.get(substring) != null && map.get(substring) > 0 && j + wordLen <= sLen) {
				count--;
				countChange = true;
				map.put(substring, map.get(substring) - 1);
				j = j + wordLen;
				if (j + wordLen > sLen)
					break;
				substring = s.substring(j, j + wordLen);
			}
			if (count == 0)
				res.add(i);
			// 3、判断是否相等，相等则继续不等就重新初始化
			if (countChange) {
				map.clear();
				count = wordsLen;
				initMap(words, map);
				countChange = false;
			}
		}
		return res;
	}

	private void initMap(String[] words, HashMap<String, Integer> map) {
		for (String word : words) {
			int num = map.getOrDefault(word, 0);
			map.put(word, num + 1);
		}
	}

	/*
	 * "aaaaaaaa" ["aa","aa","aa"]
	 */
	public static void main(String[] args) {
		LeetCode30 ls = new LeetCode30();
		String s[] = { "aa", "aa", "aa" };
		List<Integer> findSubstring = ls.findSubstring("aaaaaaaa", s);
		for (Integer integer : findSubstring) {
			System.out.println(integer);
		}
	}

}
