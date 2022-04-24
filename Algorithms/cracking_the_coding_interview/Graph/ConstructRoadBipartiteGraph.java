import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ConstructRoadBipartiteGraph {
    /*
    1.We know tree itself is bipartite
    2.RUN and DFS on tree and partition into two sets
    3.We can't add edge between two nodes on the same set but we can add edge bw two nodes
    on diff set
    4.max roads is x*y but N-1 roads already exist so max edge that can be added
    x*y-(N-1)

     */

    static int maxn=100009;
    static ArrayList<ArrayList<Integer>>adj;
    static long[]col=new long[2];
    static  long mod=1000000007;

    public static void graphC(){
        adj=new ArrayList<ArrayList<Integer>>(maxn);
        for(int i=0;i<maxn;i++){
            adj.add(new ArrayList<Integer>());
        }
        col[0]=0;
        col[1]=0;
    }
    public int solve(int A,int[][]B){
        graphC();
        if(B.length==1){
            return 0;
        }
        graphC();
        for(int[]edge:B){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long ans=col[0]*col[1];
        ans=ans-(A-1);
        ans=ans%mod;
        return (int)ans;
    }
    public static void dfs(int u,int pnode,int c){
        col[c]++;
        for(int v: adj.get(u)){
                if(v!=pnode){
                    dfs(v,u,c-1);
                }
        }
    }


    public static void main(String[] args) {
        ConstructRoadBipartiteGraph conb=new ConstructRoadBipartiteGraph();
        int n=5;
        int[][]B={{1,2},{2,3},{3,2},{3,5}};

        System.out.println(conb.solve(n,B));
    }

}
