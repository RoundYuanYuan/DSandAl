package ts.zmy.com.day01;

public class reverseWords {
	public static String reverseWords(String s) {
		String[] split = s.split(" ");
		if(split==null||split.length==0)
			return "";
		StringBuilder sB = new StringBuilder();
		for(int i=split.length-1;i>=0;i--)
		{
			if(split[i].equals(""))
				continue;
			sB.append(split[i].trim()+" ");
		}
		String res = sB.toString();
		return res.trim();
	}
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is   "));
	}
}
