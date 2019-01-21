package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
	public static Edge lastEdge(Edge edge)
	{
		while(edge.nextEdge!=null)
			edge=edge.nextEdge;
		return edge;
	}
	public static void main(String[] args) {
		//1、input vertix num and edge num
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please entry num of vertex and edge ");
		int vertexNum=scanner.nextInt();
		int edgeNum=scanner.nextInt();
		//2、input vertix set the edge list to empty
		Vertex[] vertexs=new Vertex[vertexNum];
		System.out.println("Please entry vertix !");
		for(int i=0;i<vertexNum;i++)
		{
			vertexs[i]=new Vertex(scanner.nextInt());
			vertexs[i].nextEdge=null;
		}
		//3、input v1 and v2 edge 
		for(int i=0;i<edgeNum;i++)
		{
			System.out.println("please input v1 and v2 edge ");
			int v1=scanner.nextInt();
			int v2=scanner.nextInt();
			
			if(vertexs[v1].nextEdge==null)
				vertexs[v1].nextEdge=new Edge(v2);
			else
				lastEdge(vertexs[v1].nextEdge).nextEdge=new Edge(v2);
			//无向图有效
/*			if(vertexs[v2].nextEdge==null)
				vertexs[v2].nextEdge=new Edge(v1);
			else
				lastEdge(vertexs[v2].nextEdge).nextEdge=new Edge(v1);*/
			
		}
		
		for (Vertex vertex : vertexs) {
			System.out.println(vertex.value+":");
			Edge nedge=vertex.nextEdge;
			while(nedge!=null)
			{
				System.out.println(nedge.value);
				nedge=nedge.nextEdge;
			}
		}
	}
}
