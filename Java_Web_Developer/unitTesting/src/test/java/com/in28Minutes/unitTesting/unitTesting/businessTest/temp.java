package com.in28Minutes.unitTesting.unitTesting.businessTest;

public class temp {
    public static String findLonSub(String s){
    String str1="";
    String res="";
    int n=s.length();
    int startIdx=0;
    int endIdx=0;
    int pFnd=0;
    int cnt=0;
    int maxCnt=0;
        for(int i=0;i<n;i++){
        int k=i;
        pFnd=0;
        if(maxCnt>(n-i)){
            break;
        }
        for(int j=n-1;j>=k;j--){
            int p=j;
            cnt=0;
            while(p>=k){
                char c1=s.charAt(p);
                char c2=s.charAt(k);
                if(c1==c2){
                    pFnd=1;
                    cnt++;
                    if(p!=k){
                        cnt++;
                    }
                    if(cnt>maxCnt){
                        startIdx=i;
                        endIdx=j;
                        maxCnt=cnt;
                    }
                }
                else{
                    break;
                }
                p--;
                k++;
            }
        }
    }
        System.out.println(startIdx+" "+endIdx);
        return s.substring(startIdx,endIdx+1);
}

    public static void main(String[] args) {
        String s="babad";
        System.out.println(findLonSub(s));
    }
}
