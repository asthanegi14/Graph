import java.util.*;

public class BipartiteGraph {
    static boolean bfsCall(int i,int[] col,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        col[i]=1;
        while(!q.isEmpty())
        {
            int pp = q.poll();
            for(int j:adj.get(pp))
            {
                if(col[j]==-1)
                {
                    col[j]=1-col[i];
                }
                else if(col[j]==col[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int[] col = new int[8];
        for(int i=0;i<8;i++)
        {
            col[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            if(col[i]==-1)
            {
                if(!bfsCall(i,col,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String arg[])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<8;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(7).add(2);

        if(bipartite(adj,8) == true)
        {
            System.out.println("it's a bipartite graph");
        }
        else
            System.out.println("not a bipartite");
    }
}
