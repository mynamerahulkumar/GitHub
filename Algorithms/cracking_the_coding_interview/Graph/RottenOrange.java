import javafx.util.Pair;

import java.util.*;

public class RottenOrange {
    public int orangesRotting(int[][] grid){
        int res=0;
        Queue<Pair<Integer,Integer>>queue=new ArrayDeque<>();
        // step 1. build the initial state for rotten oranges
        int freshOranges=0;
        int R=grid.length;
        int C=grid[0].length;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(grid[r][c]==2){
                    queue.offer(new Pair<>(r,c));
                }
                else if(grid[r][c]==1){
                    freshOranges++;
                }
            }
        }
        // Mark the round / level ,i.e the ticker of timestamp
        queue.offer(new Pair<>(-1,-1));
        // step 2:Start the rotating process via BFS
        int minutesElapsed=-1;
        int[][]directions={{-1,0},{0,-1},{1,0},{0,1}};

        while (!queue.isEmpty()){
            Pair<Integer,Integer>p=queue.poll();
            int row=p.getKey();
            int col=p.getValue();
            if(row==-1){
                // we finished one round of processing
                minutesElapsed++;
                //to avoid endless loop
                if(!queue.isEmpty()){
                    queue.offer(new Pair<>(-1,-1));
                }
            }
            else{
                // this is rotten orange
                // this would contaminate its orange
                for(int []d:directions){
                    int neighBoursRows=row+d[0];
                    int neighBoursCols=col+d[1];
                    if(neighBoursRows>=0 && neighBoursRows<R &&
                        neighBoursCols>=0 && neighBoursCols<C){
                        if(grid[neighBoursRows][neighBoursCols]==1){
                            // this orange would be contaminated
                            grid[neighBoursRows][neighBoursCols]=2;
                            freshOranges--;
                            // this orange can contaminate other orages
                            queue.offer(new Pair<>(neighBoursRows,neighBoursCols));
                        }
                    }
                }
            }
        }


        return  freshOranges==0?minutesElapsed:-1;
    }

}
