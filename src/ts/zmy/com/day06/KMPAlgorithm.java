package ts.zmy.com.day06;

public class KMPAlgorithm {
	public static int[] getNext(String s)
	{
		int next[] =new int[s.length()];
		int i=0;
		int j=-1;
		next[0]=-1;
		while(i<s.length())
		{
			if(j==-1||s.charAt(i)==s.charAt(j))
			{
				i++;
				j++;
				if(i==s.length())
					continue;
				else
				next[i]=j;
			}else {
				j=next[j];
			}
		}
		return next;
	}
	public static void main(String[] args) {
		String s="aba";
		int[] next = getNext(s);
		for (int i : next) {
			System.out.println(i);
		}
	}
}
