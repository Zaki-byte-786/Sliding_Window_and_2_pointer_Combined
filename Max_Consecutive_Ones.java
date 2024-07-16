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
    public static void main(String[] args) {
    int [] array = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(Max_Consecutive_Ones_Optimal(array,3));
        System.out.println(Max_Consecutive_Ones_Brute(array,3));
    }
}
