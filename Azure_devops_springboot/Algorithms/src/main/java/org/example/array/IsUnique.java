package org.example.array;

public class IsUnique {

    public boolean IsUniqueString(String str){
        int len=str.length();
        boolean[] asc=new boolean[256];
        for(int i=0;i<len;i++){
            int val=str.charAt(i);
            if(asc[val]){
                return false;
            }
            asc[val]=true;
        }
        return true;
    }
    public boolean isUniqueWithoutSpace(String str){
        int len=str.length();
        int checker=0;
        for(int i=0;i<len;i++){
            int val=str.charAt(i)-'a';
            int d=1<<val;
            if((checker &d )>0){
                return  false;
            }
            checker|=(d);
        }
        return true;
    }
    public static void main(String[] args) {
        String str="leetcode";
        IsUnique unique=new IsUnique();
        boolean isUnique=unique.isUniqueWithoutSpace(str);
        if(isUnique){
            System.out.println("String is unique-"+str);
        }
        else{
            System.out.println("String is not unique-"+str);
        }

    }
}
