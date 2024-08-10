public class MaximumPointsYouCanObtainFromCards {
    static int method(int[] array,int k){
        int leftSum = 0,rightSum = 0,maxSum = 0,n = array.length;
        for (int i = 0; i < k; i++) {
            leftSum += array[i];
        }
        maxSum = leftSum;
        int j = n-1;
        for (int i = k-1; i >= 0 ; i--) {
            leftSum -= array[i];
            rightSum += array[j];
            j--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
