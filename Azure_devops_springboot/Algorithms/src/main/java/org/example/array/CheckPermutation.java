package org.example.array;

import java.util.Arrays;

public class CheckPermutation {

      public boolean isPermutation(String str1,String str2){
          if(str1.length()!=str2.length()){
              return false;
          }
          char []chr1=str1.toCharArray();
          char[] chr2=str2.toCharArray();
          Arrays.sort(chr1);
          Arrays.sort(chr2);
          String st1=new String(chr1);
          String st2=new String(chr2);
          if(st1.equals(st2)){
              return true;
          }
          else{
              return false;
          }

      }

      public boolean isPermutation2(String str,String str2){
            int []asc=new int [128];
            if(str.length()!=str2.length()){
                return false;
            }
            for(int i=0;i<str.length();i++){
                int value=str.charAt(i);
                asc[value]++;
            }
            for(int i=0;i<str2.length();i++){
                int value=str2.charAt(i);
                asc[value]--;
                if(asc[value]<0) {
                    return false;
                }
            }
            return true;
      }
    public static void main(String[] args) {
        CheckPermutation obj=new CheckPermutation();
        String st="a";
        String st1="a";
        if(obj.isPermutation(st,st1)){
            System.out.println("Both string are permutation of each other "+st+" "+st1);
        }
        else{
            System.out.println("Both string are not permutation of each other "+st+" "+st1);

        }

    }
}
