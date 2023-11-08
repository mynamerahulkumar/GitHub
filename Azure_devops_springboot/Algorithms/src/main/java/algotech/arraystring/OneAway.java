package algotech.arraystring;

public class OneAway {
    public boolean isOneAway(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        if(len1==0 && len2==0){
            return false;
        }
        if(Math.abs(len1-len2)>=2){
            return false;
        }
        if(len1==len2){
           return isOneReplace(s1,s2);
        }
       if(len2>len1){
           String temp=s1;
           s1=s2;
           s2=temp;
       }
       return  isOneEditAway(s1,s2);



    }
    public boolean isOneReplace(String s1,String s2){
            boolean isUnmatchedFound=false;
            for(int index=0;index<s1.length();index++){
                if(s1.charAt(index)!=s2.charAt(index)){
                    if(isUnmatchedFound){
                        return false;
                    }
                    isUnmatchedFound=true;
                }
            }
            return true;

    }
    public boolean isOneEditAway(String s1,String s2){
        int index1=0;
        int index2=0;
        boolean isUnMatchingFound=false;
        while (index1<s1.length() && index2<s2.length()){
            if(s1.charAt(index1)==s2.charAt(index2)){
                index1++;
                index2++;
            }
            else {
                if(isUnMatchingFound){
                    return false;
                }
               isUnMatchingFound=true;
                index1++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1="";
        String str2="J";
        OneAway oneAway=new OneAway();
        if(oneAway.isOneAway(str1,str2)){
            System.out.println(str1+" & "+ str2 +" are one string away");
        }
        else{
            System.out.println(str1+" & "+ str2 +" are not one string away");
        }

    }
}
