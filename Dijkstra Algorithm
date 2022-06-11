import java.util.*;
class Node implements Comparator<Node>
{
    int node, weight;
    Node(int v, int u)
    {
        node=v;
        weight=u;
    }
    Node(){

    }
    int getNode() {
        return node;
    }
    int getWeight()
    {
        return weight;
    }
    @Override
    public  int compare(Node node1,Node node2){
        if(node1.weight<node2.weight)
            return -1;
        if(node1.weight>node2.weight)
            return 1;
        return 0;
    }
}
public class DijkstraAlgo {
    static ArrayList<ArrayList<Node>> adj;
    static void shortestPath(ArrayList<ArrayList<Node>> adj, int node)
    {
        int dis[] = new int[node];
        for(int i =0;i<node;i++)
        {
            dis[i]=100000000;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(node,new Node());
        int k =0;
        pq.add(new Node(k,0));
        while(!pq.isEmpty())
        {
            Node x = pq.poll();
            for(Node z : adj.get(x.getNode()))
            {
                if(dis[x.getNode()] + z.getWeight() < dis[z.getNode()])
                {
                    dis[z.getNode()] = dis[x.getNode()]+z.getWeight();
                    pq.add(new Node(z.getNode(),dis[z.getNode()]));
                }
            }
        }
        System.out.print("shortest distance between "+k+" is ");
        for(int b=0;b<node;b++)
        {
            System.out.print(dis[b]+" ");
        }
    }
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total nodes");
        int node = sc.nextInt();
        adj=new ArrayList<ArrayList<Node>>();
        for(int i=0;i<node;i++)
        {
            adj.add(new ArrayList<Node>());
        }
//        System.out.println("enter v and u");
//        int v=0;
//        int u=0;
//        for(int i=0;i<node;i++)
//        {
//            v = sc.nextInt();
//            u = sc.nextInt();
//        }
        adj.get(0).add(new Node(1,2));
        adj.get(1).add(new Node(0,2));
        adj.get(1).add(new Node(2 ,4));
        adj.get(2).add(new Node(1, 4));
        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));
        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));
        adj.get(1).add(new Node(4,5));
        adj.get(4).add(new Node(1,5));
        adj.get(2).add(new Node(4,1));
        adj.get(4).add(new Node(2,1));

        shortestPath(adj,node);

    }
}
//Some sample user inputs
//1 2
//0 2
//2 4
//1 4
//3 1
//0 1
//2 3
//3 3
//4 5
//1 5
