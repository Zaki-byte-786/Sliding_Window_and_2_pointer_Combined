public class BinarySubarraysWithSumK {
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
    public static void main(String[] args) {
        int[] array = {0,0,0,0,0};
        System.out.println(calculateNumberOfSubArray(array,0));
    }
}
