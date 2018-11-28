package ts.zmy.com.day01;

public class reverseWords {
	public static String reverseWords(String s) {
		String[] split = s.split(" ");
		StringBuilder sB = new StringBuilder();
		for(int i=split.length-1;i>=0;i--)
		{
			if(split[i].equals(""))
				continue;
			sB.append(split[i].trim()+" ");
		}
		String res = sB.toString();
		if(res.equals(""))
			return "";
		else
		return res.substring(0, res.length()-1);
	}
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is"));
	}
}
