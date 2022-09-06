package daalab;

import java.util.*;

public class GraphTraversalDfs {
    ArrayList<ArrayList<Integer>> graph;
    void dfs(int i, boolean[] vis,ArrayList<Integer> finalArr)
    {
        finalArr.add(i);
        vis[i]=true;
        for(Integer j:graph.get(i)){
            if(vis[j]==false)
            {
                dfs(j,vis,finalArr);
            }
        }
    }
    ArrayList<Integer> dfsCall(int v)
    {
        ArrayList<Integer> finalArr = new ArrayList<>();
        boolean vis[] = new boolean[v+1];
        for(int i=1;i<=v;i++)
        {
            if(vis[i]==false)
            {
                dfs(i,vis,finalArr);
            }
        }
        return finalArr;
    }
    static void PrintAns(ArrayList<Integer> ans)
    {
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total number of nodes");
        int n = sc.nextInt();
        GraphTraversalDfs g = new GraphTraversalDfs();
        g.graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            g.graph.add(new ArrayList<>());
        }

        System.out.println("enter v,u");
        for(int i=0;i<6;i++)
        {
            int v = sc.nextInt();
            int u = sc.nextInt();
            g.graph.get(v).add(u);
            g.graph.get(u).add(v);
        }
        ArrayList<Integer> ans = g.dfsCall(n-1);
        System.out.println("DFS is : ");
        PrintAns(ans);
    }
}
