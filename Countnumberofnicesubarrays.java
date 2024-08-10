public class Countnumberofnicesubarrays {
    static int Brute(int[] array,int k){
        int count = 0,n = array.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j] % 2;
                if (sum == k)count++;
                if (sum > k)break;
            }
        }
        return count;
    }
    static int SubarraysWithSumKMethod(int[] array,int k){
        if (k < 0)return 0;
        int n = array.length;
        int r = 0,l = 0,sum = 0,count = 0;
        while (r < n){
            sum += array[r] % 2;
            if (sum > k){
                while (array[l] % 2 != 1)l++;
                l++;
                sum--;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    static int calculateNumberOfSubArray(int[] array,int k){
        return SubarraysWithSumKMethod(array,k) - SubarraysWithSumKMethod(array,k-1);
    }
    public static void main(String[] args) {
int[] array = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(Brute(array,2));
        System.out.println(calculateNumberOfSubArray(array,2));
    }
}
