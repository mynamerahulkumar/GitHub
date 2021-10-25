public class Array2 {
    public static void main(String[] args) {
        public class Solution {
            public int[] flip(String A) {
                int ans=0;
                int cnt=0;
                int n=A.length();
                // find number of occurence of 1
                for(int i=0;i<n;i++){
                    if(A.charAt(i)=='1'){
                        cnt++;
                    }
                }
                ans=cnt;
                int count0=0,count1=0;
                for(int i=0;i<n;i++){// start of subarray
                    count0=0;
                    count1=0;
                    for(int j=i;j<n;j++){ // end of subarray
                        if(A.charAt(j)=='1'){
                            count1++;
                        }
                        else{
                            count0++;
                        }
                        ans=Math.max(ans,(count1-count0)+cnt);
                    }
                }
                // find the index of larger occurence
                String res="";
                int max_ans=ans;
                ans=cnt;
                int []resArr={};
                if(ans==n){
                    //  resArr={};
                    return resArr;
                }
                resArr= new int[2];
                if(ans==0){
                    resArr[0]=1;
                    resArr[1]=n;
                    return resArr;
                }
                for(int i=0;i<n;i++){
                    count0=0;
                    count1=0;
                    for(int j=i;j<n;j++){ // end of subarray
                        if(A.charAt(j)=='1'){
                            count1++;
                        }
                        else{
                            count0++;
                        }
                        ans=Math.max(ans,(count1-count0)+cnt);
                        if(ans==max_ans){
                            if(res==""){
                                res=i+""+j;
                            }
                            else if(res.compareTo(i+""+j)<0){
                                res=i+""+j;
                            }
                        }

                    }
                }
                int start=Integer.valueOf(res.charAt(0));
                int end=Integer.valueOf(res.charAt(1));
                resArr[0]=start;
                resArr[1]=end;
                return resArr;

            }
        }

    }
}
