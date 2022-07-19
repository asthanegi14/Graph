import java.util.*;
public class Scc {
    static void dfs(boolean vis[],ArrayList<ArrayList<Integer>> a,int i,Stack<Integer> s)
    {
        vis[i]=true;
        for(int j:a.get(i))
        {
            if(vis[j]==false) {
                dfs(vis, a, j, s);
            }
        }
        s.push(i);
    }
    static void reverseDfa(ArrayList<ArrayList<Integer>> transpose,int top, boolean vis[])
    {
        vis[top]=true;
        System.out.print(top+" ");
        for(int i:transpose.get(top))
        {
            if(vis[i]==false)
            {
                reverseDfa(transpose,i,vis);
            }
        }
    }
    static void kosaraju(ArrayList<ArrayList<Integer>> a,boolean vis[], int node )
    {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<5;i++)
        {
            if(vis[i]==false)
            {
                dfs(vis,a,i,s);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<5;i++)
        {
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<5;i++)
        {
            vis[i]=false;
            for(int it:a.get(i)){
                transpose.get(it).add(i);
            }
        }
        while(s.size()>0)
        {
            int top = s.peek();
            s.pop();
            if(vis[top]==false)
            {
                System.out.print("SCC ");
                reverseDfa(transpose,top,vis);
                System.out.println();
            }
        }
    }
    public static void main(String arg[])
    {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<5;i++)
        {
            a.add(new ArrayList<>());
        }
        a.get(0).add(1);
        a.get(1).add(2);
        a.get(1).add(3);
        a.get(2).add(0);
        a.get(3).add(4);
        boolean[] vis = new boolean[5];
        kosaraju(a,vis,5);
    }
}
