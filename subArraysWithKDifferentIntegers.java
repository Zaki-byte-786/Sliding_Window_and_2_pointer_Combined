import java.util.HashMap;

public class subArraysWithKDifferentIntegers {
    static int Brute(int[] array ,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count  = 0;
        for (int i = 0; i < array.length; i++) {
            map.clear();
            for (int j = i; j < array.length; j++) {
                map.put(array[j],map.getOrDefault(array[j],0) + 1);
                if (map.size() > k)break;
                if (map.size() == k)count++;
            }
        }
        return count;
    }
static int BetterHelpingFunction(int[] array,int k){
    HashMap<Integer,Integer> map = new HashMap<>();
    if (k < 0)return 0;
    int count = 0,i = 0;
    for (int j = 0; j < array.length; j++) {
        map.put(array[j],map.getOrDefault(array[j],0) + 1);
        while (map.size() > k){
            map.put(array[i],map.get(array[i]) - 1);
            if (map.get(array[i]) == 0)map.remove(array[i]);
            i++;
        }
         count += j - i + 1;
    }
    return count;
}
static int Better(int[] array,int k){
        return BetterHelpingFunction(array,k) - BetterHelpingFunction(array,k-1);
}
    public static void main(String[] args) {
        int[] array = {1,2,1,3,4};
        System.out.println(Brute(array,3));
        System.out.println(Better(array,3));


    }
}
