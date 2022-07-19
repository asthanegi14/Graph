import java.util.*;

public class ShortestPath{
    static void distanceArray(int i,ArrayList<ArrayList<Integer>> graph,int e)
    {
        int dis[] = new int[i];
        for(int j=0;j<i;j++)
        {
            dis[j]=100000000;
        }
        int k=0;
        dis[k]=0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(k);
        while(!q.isEmpty())
        {
            int n = q.poll();
            for(int x:graph.get(n))
            {
                if(dis[n]+1<dis[x])
                {
                    dis[x]=dis[n]+1;
                    q.add(x);
                }
            }
        }
        System.out.print("shortest path is: ");
        for(int j=0;j<i;j++)
        {
            System.out.print(dis[j]+" ");
        }
    }
    public static void main(String arg[])
    {
        ArrayList<ArrayList<Integer>> graph;
        Scanner sc = new Scanner(System.in);
        System.out.println("number of nodes");
        int node = sc.nextInt();
         System.out.println("number of edges");
        int e = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(node);
        for(int i=0;i<node;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        System.out.println("enter v and u");
        for(int i=0;i<e;i++)
        {
            int v = sc.nextInt();
            int u = sc.nextInt();
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        distanceArray(node,graph,e);
    }
}
