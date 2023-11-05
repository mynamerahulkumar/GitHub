package org.example.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        /**
         1- create one more array
         2-copu the last k element from start
         3-copy the remaining n-k elelemt
         4-copy back to original array

         */
        int len=nums.length;
        k=k%len;
        for(int i=0;i<k;i++){
            for(int j=0;j<len-1;j++){
                int s=nums[0];
                nums[0]=nums[j+1];
                nums[j+1]=s;
            }
        }


    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        RotateArray removeDuplicates=new RotateArray();
        removeDuplicates.rotate(arr,3);
    }
}
