package base;

import java.io.InputStream;
import java.util.Scanner;

public class AdjacencyMatrix {
	
	//1、读取所有节点
	//2、初始化邻接表
	//3、填写边
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("输入所有点，和边个数");
		int vertexNum=in.nextInt();
		int edgeNum=in.nextInt();
		int [] vertexList=new int[vertexNum];
		for(int i=0;i<vertexNum;i++)
		{
			vertexList[i]=in.nextInt();
		}
		int [][] adjacencyList=new int[vertexNum][vertexNum];
		for(int i=0;i<vertexNum;i++)
			for(int j=0;j<vertexNum;j++)
				adjacencyList[i][j]=-1;
		for(int i=0;i<edgeNum;i++)
		{
			System.out.println("请输入边");
			int start=in.nextInt();
			int end=in.nextInt();
			adjacencyList[start][end]=1;
			adjacencyList[end][start]=1;
		}
		
		for (int[] is : adjacencyList) {
			for (int is2 : is) {
				System.out.print(is2);
			}
			System.out.println();
		}
	}
}
