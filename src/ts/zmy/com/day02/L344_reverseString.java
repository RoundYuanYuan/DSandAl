package ts.zmy.com.day02;
/*要求：
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 * @Auther:Ry
 */

public class L344_reverseString {
	public static String reverseString(String s) {
		char[] CharArray = s.toCharArray();
		int len = CharArray.length;
		StringBuilder sB = new StringBuilder();
		for(int i=len-1;i>-1;i--)
		{
			sB.append(CharArray[i]);
		}
		return sB.toString();
	}
	public static void main(String[] args) {
		System.out.println(reverseString("A man, a plan, a canal: Panama"));
	}
}
