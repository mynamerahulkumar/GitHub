import java.util.Collections;
import java.util.Scanner;

public class MaximumXOR {
    /*
        A=[1,2,3,4,5]
        step 1) convert to binary each number
        step 2) add 1 to the Trie
        step 3) do xor of 2 with Trie and try to get max value
             3.1) if node has 2 values try to get which has max 0^1=1
        step 4)add 2 to the Trie
        step 5) step 3 and step 4 and get max xor from step 3
     */
   static class TrieNode3{
        TrieNode3[] Trie;
        int cntNode;
        int data;
        public TrieNode3(){
            Trie=new TrieNode3[2];
            for(int i=0;i<2;i++){
                Trie[i]=null;
            }
        }
    }
    public void InsertNode(TrieNode3 root,String bits,int val){
        TrieNode3 temp=root;
        for(int i=0;i<bits.length();i++){
            int a=bits.charAt(i)-'0';
            if(temp.Trie[a]==null){
                temp.Trie[a]=new TrieNode3();
                temp.Trie[a].cntNode=1;
            }
            else{
                temp.Trie[a].cntNode++;// if two node has common bits add cnt node=2
            }
            temp=temp.Trie[a];
            if(i==bits.length()-1){
                temp.data=val; // in the end  add data
            }
        }

    }
    public int getMaxXor(TrieNode3 root,String bit1,int  val){
        int result=-1;
        TrieNode3 temp=root;
        System.out.println(bit1+"--"+val);
        for(int i=0;i<bit1.length();i++){
            int a=bit1.charAt(i)-'0';
            if(temp.Trie[a]!=null){
                if(temp.Trie[a].cntNode==1){
                    temp=temp.Trie[a];
                    if(i==bit1.length()-1){
                        result=temp.cntNode;
                    }
                }
                else if(temp.Trie[a].cntNode>=2){
                        char bit=' ';
                       // a=bit1.charAt(i+1)-'0';
                        if(bit1.charAt(i+1)=='0'){
                           temp= temp.Trie[1];
                           if(i==bit1.length()-1){
                               result=temp.data;
                           }
                        }
                        else{
                            temp=temp.Trie[0];
                            if(i==bit1.length()-1){
                                result=temp.data;
                            }
                        }

                }
            }
        }
        result=getXor(result,val);
        return  result;
    }
    public  int  getXor(int x,int y){
       int result=0;
       for(int i=0;i<32;i++){
           if(((1<<i)&x)!=((1<<i)&y)){
               result|=1<<i;
           }
       }
       return result;
    }
    public  String convertToBits(int val){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<32;i++){
            if(val>0){
                int num=val%2;
                if(num==1) {
                    sb.append('1');
                }
                else{
                    sb.append('0');
                }
                val=val/2;
            }
            else{
                sb.append('0');
            }
        }
        sb=sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array:");
        int n=sc.nextInt();
        int[]arr=new int[n];
        int result=0;
        for(int i=0;i<n;i++){
            System.out.print("Enter input:");
            arr[i]=sc.nextInt();
        }
        // make trie node and get max xor
        MaximumXOR obj=new MaximumXOR();
        TrieNode3 root=new TrieNode3();
        if(n==1){
            result=arr[0];
        }

        for(int i=0;i<n;i++){
            String bits=obj.convertToBits(arr[i]);
            if(i==0){
              obj.InsertNode(root,bits,arr[i]);
            }
            else{
                result=Math.max(obj.getMaxXor(root,bits,arr[i]),result);
                System.out.println(result);
                obj.InsertNode(root,bits,arr[i]);
            }
        }
    }
}
