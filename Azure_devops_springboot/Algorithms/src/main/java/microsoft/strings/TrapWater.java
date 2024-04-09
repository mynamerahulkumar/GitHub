package microsoft.strings;

public class TrapWater {
    public static int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=0;
        int i=1;
        left=1;
        if(n<=2){
            return 0;
        }
        right=2;
        int total=0;
        while(right<n){
            while(right<n && height[left]>height[right]){
                right++;
            }
            int s=0;
            if(right<n){
                int j=left;
                while(j<right){
                    s+=height[left]-height[j];
                    j++;
                }
                total+=s;
                left=right;
                right=left+1;
            }
            else{
                left=left+1;
                right=left+1;
            }



        }
        return total;


    }
    public static void main(String[] args) {
        int[] array={0,1,0,2,1,0,1,3,2,1,2,1};
        TrapWater trapWater=new TrapWater();
        TrapWater.trap(array);
    }
}
