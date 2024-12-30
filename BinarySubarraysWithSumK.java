public class BinarySubarraysWithSumK {
    static int BinarySubarraysWithSumKBrute(int[] array,int k){
        int count = 0,n = array.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                if (sum == k)count++;
                if (sum > k)break;
            }
        }
        return count;
    }
    static int BinarySubarraysWithSumKMethod(int[] array,int k){
        if (k < 0)return 0;
        int n = array.length;
        int r = 0,l = 0,sum = 0,count = 0;
        while (r < n){
            sum += array[r];
            if (sum > k){
                while (array[l] != 1)l++;
                l++;
                sum--;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    static int calculateNumberOfSubArray(int[] array,int k){
        return BinarySubarraysWithSumKMethod(array,k) - BinarySubarraysWithSumKMethod(array,k-1);
    }

//    easy code for optimal case
//    int function(int[] nums, int goal){
//        if(goal < 0)return 0;
//        int sum = 0,j = 0,count = 0;
//        for(int i = 0;i < nums.length;i++){
//            sum += nums[i];
//            while(sum > goal){
//                sum -= nums[j];
//                j++;
//            }
//            count += i - j + 1;
//        }
//        return count;
//    }
//    public int numSubarraysWithSum(int[] nums, int goal) {
//        return function(nums,goal)-function(nums,goal - 1);
//    }
    public static void main(String[] args) {
        int[] array = {1,0,1,0,0,1};
        System.out.println(calculateNumberOfSubArray(array,0));
        System.out.println(BinarySubarraysWithSumKBrute(array,0));
    }
}
