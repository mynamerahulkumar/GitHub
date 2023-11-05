package org.example.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=2){
            return len;
        }
        int k=0;

        int count=0;
        int resCount=0;
        for(int i=0;i<len;i++){

            if(i<len-1 && nums[i]==nums[i+1]){
                count++;
                resCount++;

            }
            else if(i<len-1 && nums[i]!=nums[i+1]){
                resCount++;
                count=0;
            }
            if(count>=2){
                if(i<len-2){
                    if(nums[i+1]!=nums[i+2]){
                        count=0;
                    }
                }
                int l=i;
                while(l<len-1 &&nums[l]==nums[l+1]) {
                    int j=l;
                    for ( j = i + 1; j < len - 1; j++) {
                        int s = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = s;
                    }

                }

            }

        }
        return resCount;

    }
    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,1,2,3,3};
        RemoveDuplicates removeDuplicates=new RemoveDuplicates();
        removeDuplicates.removeDuplicates(arr);
    }
}
