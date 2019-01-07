import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
            int[] stationP=new int[n];
                int len=c.length;
                for(int i=0;i<len;i++){
                stationP[c[i]]=1;
                }
                int max=0;
                int backD=0;
                int forwD=0;
                for(int i=0;i<n;i++){
                    if(stationP[i]!=1){//if gas is not present
                    int fnd=0;
                    backD=0;
                    forwD=0;
                    for(int k=i-1;k>=0;k--){//search backward from city
                        if(stationP[k]==1){
                         backD++;
                        fnd=1;
                        break;
                        }
                        backD++;
                    }
                   fnd=0;
                    for(int k=i+1;k<n;k++){//search forward from city
                        if(stationP[k]==1){
                         forwD++;
                        fnd=1;
                        break;
                        }
                         forwD++;
                    }
                    int dis=0;//find min distane from pump
                    if(backD !=0 && forwD !=0){
                      dis= backD<forwD ? backD:forwD;
                    }
                    else if(backD!=0 && forwD ==0){
                        dis=backD;
                    }
                    else{
                        dis=forwD;
                    }
                    if(dis > max){
                    max=dis;
                    }
                }
                }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
