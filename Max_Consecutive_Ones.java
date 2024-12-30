public class Max_Consecutive_Ones {
    static int Max_Consecutive_Ones_Brute(int[] array,int k){
        int n = array.length, max = 0, zero, length;
        if (array.length == 0)return 0;
        if (array.length == 1){
            if(array[0] == 0 && k == 0)return 0;
            else return 1;
        }
        for (int i = 0; i < n; i++) {
            zero = 0;
            for (int j = i; j < n; j++) {
                if (array[j] == 0)zero++;
                if (zero > k)break;
                length = j - i + 1;
                max = Math.max(max,length);
            }
        }
        return max;
    }

//    2nd code
//public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
//    // Write your code here.
//    int maxLength = 0,zero = 0;
//    for(int i = 0;i < arr.size();i++){
//        zero = 0;
//        for(int j = i;j < arr.size();j++){
//            if(arr.get(j) == 0)zero++;
//            if(zero > k){
//                break;
//            }
//            maxLength = Math.max(maxLength,j - i + 1);
//        }
//    }
//    return maxLength;
//}

    static int Max_Consecutive_Ones_Optimal(int[] array,int k){
        int i = 0, n = array.length, max = 0, zero = 0, length;
        if (array.length == 0)return 0;
        if (array.length == 1){
            if(array[0] == 0 && k == 0)return 0;
            else return 1;
        }
        for (int l = 0; l < n; l++) {
            if (array[l] == 0)zero++;
            if (zero > k){
                while (array[i] != 0) i++;
                i++;
                zero--;
            }
            length = l - i + 1;
            max = Math.max(length,max);
        }
        return max;
    }
    static int Max_Consecutive_Ones_OptimalOfOptimal(int[] array,int k){
        int i = 0, n = array.length, max = 0, zero = 0, length;
        if (array.length == 0)return 0;
        if (array.length == 1){
            if(array[0] == 0 && k == 0)return 0;
            else return 1;
        }
        for (int l = 0; l < n; l++) {
            if (array[l] == 0)zero++;
            if (zero > k){
                if (array[i] == 0)zero--;
                i++;
            }
            else {
                length = l - i + 1;
                max = Math.max(length,max);
            }

        }
        return max;
    }
//    3rd optimal
//public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
//    // Write your code here.
//    int maxLength = 0,j = 0,zero = 0;
//    for(int i = 0;i < arr.size();i++){
//        if(arr.get(i) == 0)zero++;
//        while(zero > k){
//            if(arr.get(j) == 0){
//                zero--;
//            }
//            j++;
//        }
//        maxLength = Math.max(maxLength,i - j + 1);
//    }
//    return maxLength;
//}



//    max consecutive one without k
//    brute
//public int findMaxConsecutiveOnes(int[] nums) {
//    // if(nums.length == 1)return nums[0];
//    int maxLength = 0;
//    for(int i = 0;i < nums.length;i++){
//        for(int j = i;j < nums.length;j++){
//            if(nums[j] == 0){
//                i = j;
//                break;
//            }
//            maxLength = Math.max(maxLength,j - i + 1);
//        }
//    }
//    return maxLength;
//}

//    optimal
//public int findMaxConsecutiveOnes(int[] nums) {
//    int maxLength = 0,j = 0;
//    for(int i = 0;i < nums.length;i++){
//        if(nums[i] == 0){
//            j = i;
//            j++;
//            continue;
//        }
//        maxLength = Math.max(maxLength,i - j + 1);
//    }
//    return maxLength;
//}



    public static void main(String[] args) {
    int [] array = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(Max_Consecutive_Ones_Optimal(array,3));
        System.out.println(Max_Consecutive_Ones_Brute(array,3));
    }
}
